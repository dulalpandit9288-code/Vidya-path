package com.example.data.model

enum class SubjectType(
    val title: String,
    val hindiLabel: String,
    val shortDesc: String
) {
    MATH("Math", "गणित", "Concepts, Formulas & Problem Solving"),
    SCIENCE("Science", "विज्ञान", "Experiments, Diagrams & Core Theory"),
    HINDI("Hindi", "हिंदी", "व्याकरण, पाठ सार एवं अभ्यास"),
    ENGLISH("English", "अंग्रेज़ी", "Grammar, Comprehension & Literature");

    companion object {
        fun fromName(value: String?): SubjectType {
            return entries.firstOrNull { it.name.equals(value, ignoreCase = true) } ?: MATH
        }
    }
}

enum class SchoolStage(val label: String, val badge: String) {
    PRIMARY("Primary Wing", "Classes 1–5"),
    MIDDLE("Middle School", "Classes 6–8"),
    SECONDARY("Board Prep", "Classes 9–10"),
    SENIOR_SECONDARY("Sr. Secondary", "Classes 11–12");

    companion object {
        fun forClass(classNumber: Int): SchoolStage = when (classNumber) {
            in 1..5 -> PRIMARY
            in 6..8 -> MIDDLE
            in 9..10 -> SECONDARY
            else -> SENIOR_SECONDARY
        }
    }
}

data class StudyChapter(
    val id: String,
    val chapterNumber: Int,
    val title: String,
    val summary: String,
    val keyPoints: List<String>,
    val formulaOrRule: String,
    val examplePrompt: String
)

data class QuizQuestion(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctIndex: Int,
    val explanation: String
)

data class SubjectContent(
    val classNumber: Int,
    val subject: SubjectType,
    val chapters: List<StudyChapter>,
    val quiz: List<QuizQuestion>
)

enum class ChatMode {
    TEXT_CHAT,
    PHOTO_SOLVER
}

data class ChatMessage(
    val id: String,
    val isUser: Boolean,
    val text: String,
    val isStreaming: Boolean = false,
    val isPhotoResult: Boolean = false,
    val imageUriString: String? = null,
    val timestampMillis: Long = System.currentTimeMillis()
)
