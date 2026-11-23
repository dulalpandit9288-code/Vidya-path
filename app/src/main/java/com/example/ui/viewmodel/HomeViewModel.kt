package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.curriculum.CurriculumRepository
import com.example.data.model.SubjectContent
import com.example.data.model.SubjectType
import com.example.data.preferences.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val curriculumRepository: CurriculumRepository,
    private val prefsRepository: UserPreferencesRepository
) : ViewModel() {

    val selectedClass: StateFlow<Int> = prefsRepository.selectedClass
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = 10
        )

    val completedChapters: StateFlow<Set<String>> = prefsRepository.completedChapters
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = emptySet()
        )

    val quizBestScores: StateFlow<Map<String, Int>> = prefsRepository.quizBestScores
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = emptyMap()
        )

    fun selectClass(classNumber: Int) {
        viewModelScope.launch {
            prefsRepository.setSelectedClass(classNumber)
        }
    }

    fun getSubjectsForClass(classNumber: Int): List<SubjectContent> {
        return curriculumRepository.getSubjectsForClass(classNumber)
    }

    fun getSubjectContent(classNumber: Int, subject: SubjectType): SubjectContent {
        return curriculumRepository.getSubjectContent(classNumber, subject)
    }

    fun toggleChapterCompleted(chapterId: String) {
        viewModelScope.launch {
            prefsRepository.toggleChapterCompleted(chapterId)
        }
    }

    fun saveQuizScore(classNumber: Int, subject: SubjectType, score: Int) {
        viewModelScope.launch {
            prefsRepository.saveQuizBestScore(classNumber, subject.name, score)
        }
    }

    class Factory(
        private val curriculumRepository: CurriculumRepository,
        private val prefsRepository: UserPreferencesRepository
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeViewModel(curriculumRepository, prefsRepository) as T
        }
    }
}
