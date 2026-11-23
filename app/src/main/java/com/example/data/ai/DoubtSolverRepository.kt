package com.example.data.ai

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.util.Log
import com.example.data.model.ChatMessage
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.content
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import kotlin.math.max

private const val TAG = "DoubtSolverRepo"

class DoubtSolverRepository {

    private val textTutorModel by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            systemInstruction = content {
                text(
                    "You are VidyaPath AI, a warm, encouraging Indian school tutor for CBSE/NCERT students from Class 1 to Class 12. " +
                        "Explain concepts clearly in simple English (with helpful Hindi terms in brackets if relevant for Hindi/Science/Math). " +
                        "Use numbered steps, clear bullet points, and highlight final answers clearly. " +
                        "Keep explanations age-appropriate for the student's selected class."
                )
            }
        )
    }

    private val photoSolverModel by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            systemInstruction = content {
                text(
                    "You are VidyaPath Photo Solver, an expert Indian Math & Science tutor for Class 1 to Class 12. " +
                        "When given an image of a handwritten or printed textbook question: " +
                        "1. First state 'Question Identified:' and transcribe the problem clearly. " +
                        "2. State 'Given & Formula:' listing known values and formulas used. " +
                        "3. Provide a clear 'Step-by-Step Solution:' with numbered steps so the student understands every calculation. " +
                        "4. End with 'Final Answer:' clearly highlighted. " +
                        "If the photo is blurry or unreadable, politely tell the student what part is unclear."
                )
            }
        )
    }

    fun askTextDoubtStream(
        question: String,
        classNumber: Int,
        subjectLabel: String,
        recentHistory: List<ChatMessage>
    ): Flow<String> = flow {
        val historyContents = recentHistory
            .filter { !it.isStreaming && it.text.isNotBlank() && !it.isPhotoResult }
            .takeLast(8)
            .map { msg ->
                content(role = if (msg.isUser) "user" else "model") {
                    text(msg.text)
                }
            }

        val chat = textTutorModel.startChat(history = historyContents)
        val contextualPrompt = "[Student Context: Class $classNumber • $subjectLabel]\n$question"

        val accumulated = StringBuilder()
        chat.sendMessageStream(contextualPrompt).collect { chunk ->
            val piece = chunk.text.orEmpty()
            if (piece.isNotEmpty()) {
                accumulated.append(piece)
                emit(accumulated.toString())
            }
        }
    }

    fun solvePhotoDoubtStream(
        bitmap: Bitmap,
        userHint: String,
        classNumber: Int,
        subjectLabel: String
    ): Flow<String> = flow {
        val hintSection = if (userHint.isNotBlank()) {
            "\nStudent's extra note: $userHint"
        } else {
            ""
        }
        val prompt = content {
            image(bitmap)
            text(
                "Please solve this Class $classNumber ($subjectLabel) question from the photo step by step.$hintSection"
            )
        }

        val accumulated = StringBuilder()
        photoSolverModel.generateContentStream(prompt).collect { chunk ->
            val piece = chunk.text.orEmpty()
            if (piece.isNotEmpty()) {
                accumulated.append(piece)
                emit(accumulated.toString())
            }
        }
    }

    suspend fun loadScaledBitmap(context: Context, uri: Uri): Bitmap? = withContext(Dispatchers.IO) {
        try {
            val resolver = context.contentResolver

            // 1. Decode bounds first
            val boundsOptions = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            resolver.openInputStream(uri)?.use { stream ->
                BitmapFactory.decodeStream(stream, null, boundsOptions)
            }

            val maxDimension = 1440
            val largestSide = max(boundsOptions.outWidth, boundsOptions.outHeight)
            var sampleSize = 1
            while (largestSide / sampleSize > maxDimension) {
                sampleSize *= 2
            }

            val decodeOptions = BitmapFactory.Options().apply {
                inSampleSize = sampleSize
                inPreferredConfig = Bitmap.Config.ARGB_8888
            }
            val decoded = resolver.openInputStream(uri)?.use { stream ->
                BitmapFactory.decodeStream(stream, null, decodeOptions)
            } ?: return@withContext null

            // 2. Apply EXIF orientation if available
            val rotationDegrees = resolver.openInputStream(uri)?.use { exifStream ->
                val exif = ExifInterface(exifStream)
                when (exif.getAttributeInt(
                    ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_NORMAL
                )) {
                    ExifInterface.ORIENTATION_ROTATE_90 -> 90f
                    ExifInterface.ORIENTATION_ROTATE_180 -> 180f
                    ExifInterface.ORIENTATION_ROTATE_270 -> 270f
                    else -> 0f
                }
            } ?: 0f

            val rotated = if (rotationDegrees != 0f) {
                val matrix = Matrix().apply { postRotate(rotationDegrees) }
                Bitmap.createBitmap(decoded, 0, 0, decoded.width, decoded.height, matrix, true)
                    .also { if (it != decoded) decoded.recycle() }
            } else {
                decoded
            }

            // 3. Compress/re-verify size stays well below 20MB inline limit
            val out = ByteArrayOutputStream()
            rotated.compress(Bitmap.CompressFormat.JPEG, 85, out)
            val bytes = out.toByteArray()
            BitmapFactory.decodeByteArray(bytes, 0, bytes.size) ?: rotated
        } catch (e: Exception) {
            Log.e(TAG, "Failed to decode photo URI: $uri", e)
            null
        }
    }
}
