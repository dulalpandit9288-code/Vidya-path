package com.example.ui.viewmodel

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.ai.DoubtSolverRepository
import com.example.data.model.ChatMessage
import com.example.data.model.ChatMode
import com.example.data.model.SubjectType
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import java.util.UUID

private const val TAG = "DoubtSolverViewModel"

sealed interface AiCallState {
    data object Idle : AiCallState
    data object Loading : AiCallState
    data class Streaming(val partialText: String) : AiCallState
    data class Success(val text: String) : AiCallState
    data class Error(val message: String) : AiCallState
}

data class DoubtSolverUiState(
    val activeMode: ChatMode = ChatMode.TEXT_CHAT,
    val selectedClass: Int = 10,
    val selectedSubject: SubjectType = SubjectType.MATH,
    val textInput: String = "",
    val lastSubmittedQuestion: String? = null,
    val messages: List<ChatMessage> = emptyList(),
    val freeChatState: AiCallState = AiCallState.Idle,
    val selectedPhotoUri: Uri? = null,
    val photoHintInput: String = "",
    val photoSolutionState: AiCallState = AiCallState.Idle
)

class DoubtSolverViewModel(
    private val doubtRepo: DoubtSolverRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DoubtSolverUiState())
    val uiState: StateFlow<DoubtSolverUiState> = _uiState.asStateFlow()

    fun setMode(mode: ChatMode) {
        _uiState.update { it.copy(activeMode = mode) }
    }

    fun setContext(classNumber: Int, subject: SubjectType) {
        _uiState.update {
            it.copy(
                selectedClass = classNumber.coerceIn(1, 12),
                selectedSubject = subject
            )
        }
    }

    fun updateTextInput(value: String) {
        _uiState.update { it.copy(textInput = value) }
    }

    fun updatePhotoHintInput(value: String) {
        _uiState.update { it.copy(photoHintInput = value) }
    }

    fun setSelectedPhotoUri(uri: Uri?) {
        _uiState.update {
            it.copy(
                selectedPhotoUri = uri,
                photoSolutionState = AiCallState.Idle
            )
        }
    }

    fun prefillTopicPrompt(classNumber: Int, subject: SubjectType, prompt: String) {
        _uiState.update {
            it.copy(
                activeMode = ChatMode.TEXT_CHAT,
                selectedClass = classNumber,
                selectedSubject = subject,
                textInput = prompt
            )
        }
    }

    fun clearChatHistory() {
        _uiState.update {
            it.copy(
                messages = emptyList(),
                lastSubmittedQuestion = null,
                freeChatState = AiCallState.Idle
            )
        }
    }

    fun retryLastTextQuestion() {
        val last = _uiState.value.lastSubmittedQuestion ?: return
        sendTextQuestion(overrideQuestion = last)
    }

    fun sendTextQuestion(overrideQuestion: String? = null) {
        val current = _uiState.value
        val question = (overrideQuestion ?: current.textInput).trim()
        if (question.isEmpty() || current.freeChatState is AiCallState.Loading || current.freeChatState is AiCallState.Streaming) {
            return
        }

        val userMsg = ChatMessage(
            id = UUID.randomUUID().toString(),
            isUser = true,
            text = question
        )
        val assistantMsgId = UUID.randomUUID().toString()
        val historySnapshot = current.messages

        val shouldAppendUserMsg = overrideQuestion == null ||
            current.messages.lastOrNull()?.let { it.isUser && it.text == question } != true

        _uiState.update {
            it.copy(
                textInput = if (overrideQuestion == null) "" else it.textInput,
                lastSubmittedQuestion = question,
                messages = it.messages +
                    (if (shouldAppendUserMsg) listOf(userMsg) else emptyList()) +
                    ChatMessage(
                        id = assistantMsgId,
                        isUser = false,
                        text = "",
                        isStreaming = true
                    ),
                freeChatState = AiCallState.Loading
            )
        }

        viewModelScope.launch {
            var latestText = ""
            try {
                withTimeout(60_000L) {
                    doubtRepo.askTextDoubtStream(
                        question = question,
                        classNumber = current.selectedClass,
                        subjectLabel = current.selectedSubject.title,
                        recentHistory = historySnapshot
                    ).collect { accumulated ->
                        latestText = accumulated
                        _uiState.update { state ->
                            state.copy(
                                freeChatState = AiCallState.Streaming(accumulated),
                                messages = state.messages.map { msg ->
                                    if (msg.id == assistantMsgId) {
                                        msg.copy(text = accumulated, isStreaming = true)
                                    } else msg
                                }
                            )
                        }
                    }
                }

                if (latestText.isNotBlank()) {
                    _uiState.update { state ->
                        state.copy(
                            freeChatState = AiCallState.Success(latestText),
                            messages = state.messages.map { msg ->
                                if (msg.id == assistantMsgId) {
                                    msg.copy(text = latestText, isStreaming = false)
                                } else msg
                            }
                        )
                    }
                } else {
                    val emptyMsg = "AI tutor returned an empty response. Please try asking again."
                    _uiState.update { state ->
                        state.copy(
                            freeChatState = AiCallState.Error(emptyMsg),
                            messages = state.messages.filterNot { it.id == assistantMsgId }
                        )
                    }
                }
            } catch (e: TimeoutCancellationException) {
                Log.e(TAG, "Text doubt timed out", e)
                _uiState.update { state ->
                    state.copy(
                        freeChatState = AiCallState.Error("Request timed out after 60 seconds. Please check your connection and try again."),
                        messages = state.messages.filterNot { it.id == assistantMsgId && it.text.isBlank() }
                            .map { if (it.id == assistantMsgId) it.copy(isStreaming = false) else it }
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "Text doubt failed", e)
                _uiState.update { state ->
                    state.copy(
                        freeChatState = AiCallState.Error(
                            e.localizedMessage ?: "Unable to connect to AI Doubt Solver. Please try again."
                        ),
                        messages = state.messages.filterNot { it.id == assistantMsgId }
                    )
                }
            }
        }
    }

    fun solvePhotoDoubt(context: Context) {
        val current = _uiState.value
        val uri = current.selectedPhotoUri ?: return
        if (current.photoSolutionState is AiCallState.Loading || current.photoSolutionState is AiCallState.Streaming) {
            return
        }

        _uiState.update { it.copy(photoSolutionState = AiCallState.Loading) }

        viewModelScope.launch {
            var latestSolution = ""
            try {
                val bitmap = doubtRepo.loadScaledBitmap(context.applicationContext, uri)
                if (bitmap == null) {
                    _uiState.update {
                        it.copy(photoSolutionState = AiCallState.Error("Could not read the selected image. Please pick or capture another photo."))
                    }
                    return@launch
                }

                withTimeout(60_000L) {
                    doubtRepo.solvePhotoDoubtStream(
                        bitmap = bitmap,
                        userHint = current.photoHintInput.trim(),
                        classNumber = current.selectedClass,
                        subjectLabel = current.selectedSubject.title
                    ).collect { accumulated ->
                        latestSolution = accumulated
                        _uiState.update {
                            it.copy(photoSolutionState = AiCallState.Streaming(accumulated))
                        }
                    }
                }

                if (latestSolution.isNotBlank()) {
                    _uiState.update {
                        it.copy(photoSolutionState = AiCallState.Success(latestSolution))
                    }
                } else {
                    _uiState.update {
                        it.copy(photoSolutionState = AiCallState.Error("Could not extract a solution from this photo. Try a clearer, well-lit angle."))
                    }
                }
            } catch (e: TimeoutCancellationException) {
                Log.e(TAG, "Photo doubt timed out", e)
                _uiState.update {
                    it.copy(photoSolutionState = AiCallState.Error("Photo analysis timed out after 60 seconds. Please try again."))
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "Photo doubt failed", e)
                _uiState.update {
                    it.copy(
                        photoSolutionState = AiCallState.Error(
                            e.localizedMessage ?: "Failed to solve photo question. Please try again."
                        )
                    )
                }
            }
        }
    }

    class Factory(
        private val doubtRepo: DoubtSolverRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DoubtSolverViewModel(doubtRepo) as T
        }
    }
}
