package com.example

import com.example.data.curriculum.CurriculumRepository
import com.example.data.model.SubjectType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CurriculumTest {

    @Test
    fun allClassesAndSubjectsHaveStudyNotesAndQuizzes() {
        val repo = CurriculumRepository()
        for (classNumber in 1..12) {
            val subjects = repo.getSubjectsForClass(classNumber)
            assertEquals("Class $classNumber should have 4 subjects", 4, subjects.size)
            SubjectType.entries.forEach { subject ->
                val content = repo.getSubjectContent(classNumber, subject)
                assertTrue(
                    "Class $classNumber ${subject.title} should have at least 2 chapters",
                    content.chapters.size >= 2
                )
                assertTrue(
                    "Class $classNumber ${subject.title} should have at least 4 quiz questions",
                    content.quiz.size >= 4
                )
                content.quiz.forEach { question ->
                    assertEquals(4, question.options.size)
                    assertTrue(question.correctIndex in 0..3)
                }
            }
        }
    }
}
