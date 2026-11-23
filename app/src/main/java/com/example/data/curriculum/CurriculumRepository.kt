package com.example.data.curriculum

import com.example.data.model.QuizQuestion
import com.example.data.model.StudyChapter
import com.example.data.model.SubjectContent
import com.example.data.model.SubjectType

internal data class ClassSubjectSeed(
    val classNumber: Int,
    val subject: SubjectType,
    val ch1Title: String,
    val ch1Summary: String,
    val ch1Points: List<String>,
    val ch1Formula: String,
    val ch2Title: String,
    val ch2Summary: String,
    val ch2Points: List<String>,
    val ch2Formula: String,
    val questions: List<QuizQuestion>
)

internal fun buildContent(seed: ClassSubjectSeed): SubjectContent {
    val prefix = "c${seed.classNumber}_${seed.subject.name.lowercase()}"
    return SubjectContent(
        classNumber = seed.classNumber,
        subject = seed.subject,
        chapters = listOf(
            StudyChapter(
                id = "${prefix}_ch1",
                chapterNumber = 1,
                title = seed.ch1Title,
                summary = seed.ch1Summary,
                keyPoints = seed.ch1Points,
                formulaOrRule = seed.ch1Formula,
                examplePrompt = "Explain Class ${seed.classNumber} ${seed.subject.title}: ${seed.ch1Title} with an easy solved example."
            ),
            StudyChapter(
                id = "${prefix}_ch2",
                chapterNumber = 2,
                title = seed.ch2Title,
                summary = seed.ch2Summary,
                keyPoints = seed.ch2Points,
                formulaOrRule = seed.ch2Formula,
                examplePrompt = "Give me 2 important practice questions and answers for Class ${seed.classNumber} ${seed.subject.title}: ${seed.ch2Title}."
            )
        ),
        quiz = seed.questions
    )
}

internal fun q(
    id: String,
    question: String,
    options: List<String>,
    correctIndex: Int,
    explanation: String
) = QuizQuestion(
    id = id,
    question = question,
    options = options,
    correctIndex = correctIndex,
    explanation = explanation
)

class CurriculumRepository {
    private val allContent: Map<Pair<Int, SubjectType>, SubjectContent> by lazy {
        (primarySeeds() + middleSeeds() + secondarySeeds())
            .map { buildContent(it) }
            .associateBy { it.classNumber to it.subject }
    }

    fun getSubjectContent(classNumber: Int, subject: SubjectType): SubjectContent {
        val safeClass = classNumber.coerceIn(1, 12)
        return allContent[safeClass to subject]
            ?: error("Missing curriculum for Class $safeClass ${subject.title}")
    }

    fun getSubjectsForClass(classNumber: Int): List<SubjectContent> {
        return SubjectType.entries.map { getSubjectContent(classNumber, it) }
    }
}
