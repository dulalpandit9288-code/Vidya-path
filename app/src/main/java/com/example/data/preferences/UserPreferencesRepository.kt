package com.example.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.vidyaDataStore: DataStore<Preferences> by preferencesDataStore(name = "vidyapath_prefs")

class UserPreferencesRepository(private val context: Context) {

    private object Keys {
        val SELECTED_CLASS = intPreferencesKey("selected_class")
        val COMPLETED_CHAPTERS = stringSetPreferencesKey("completed_chapters")
        val QUIZ_SCORES = stringSetPreferencesKey("quiz_scores") // stored as "class_SUBJECT:score"
    }

    val selectedClass: Flow<Int> = context.vidyaDataStore.data.map { prefs ->
        prefs[Keys.SELECTED_CLASS] ?: 10
    }

    val completedChapters: Flow<Set<String>> = context.vidyaDataStore.data.map { prefs ->
        prefs[Keys.COMPLETED_CHAPTERS] ?: emptySet()
    }

    val quizBestScores: Flow<Map<String, Int>> = context.vidyaDataStore.data.map { prefs ->
        val raw = prefs[Keys.QUIZ_SCORES] ?: emptySet()
        raw.mapNotNull { entry ->
            val parts = entry.split(":")
            if (parts.size == 2) {
                parts[1].toIntOrNull()?.let { score -> parts[0] to score }
            } else null
        }.toMap()
    }

    suspend fun setSelectedClass(classNumber: Int) {
        context.vidyaDataStore.edit { prefs ->
            prefs[Keys.SELECTED_CLASS] = classNumber.coerceIn(1, 12)
        }
    }

    suspend fun toggleChapterCompleted(chapterId: String) {
        context.vidyaDataStore.edit { prefs ->
            val current = prefs[Keys.COMPLETED_CHAPTERS]?.toMutableSet() ?: mutableSetOf()
            if (current.contains(chapterId)) {
                current.remove(chapterId)
            } else {
                current.add(chapterId)
            }
            prefs[Keys.COMPLETED_CHAPTERS] = current
        }
    }

    suspend fun saveQuizBestScore(classNumber: Int, subjectKey: String, score: Int) {
        val key = "${classNumber}_$subjectKey"
        context.vidyaDataStore.edit { prefs ->
            val current = prefs[Keys.QUIZ_SCORES]?.toMutableSet() ?: mutableSetOf()
            val existing = current.firstOrNull { it.startsWith("$key:") }
            val previousScore = existing?.substringAfter(":")?.toIntOrNull() ?: -1
            if (score >= previousScore) {
                if (existing != null) current.remove(existing)
                current.add("$key:$score")
                prefs[Keys.QUIZ_SCORES] = current
            }
        }
    }
}
