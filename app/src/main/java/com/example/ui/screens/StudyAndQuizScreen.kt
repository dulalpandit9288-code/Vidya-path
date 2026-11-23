package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.model.QuizQuestion
import com.example.data.model.StudyChapter
import com.example.data.model.SubjectContent
import com.example.ui.components.subjectVisual
import com.example.ui.theme.JetBrainsMonoFontFamily
import com.example.ui.theme.QuizCorrect
import com.example.ui.theme.QuizCorrectBg
import com.example.ui.theme.QuizWrong
import com.example.ui.theme.QuizWrongBg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyAndQuizScreen(
    content: SubjectContent,
    completedChapters: Set<String>,
    bestScore: Int?,
    onBack: () -> Unit,
    onToggleChapterComplete: (String) -> Unit,
    onQuizCompleted: (Int) -> Unit,
    onAskAiWithPrompt: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val visual = subjectVisual(content.subject)
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Class ${content.classNumber} • ${content.subject.title}",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = content.subject.hindiLabel,
                            style = MaterialTheme.typography.bodySmall,
                            color = visual.accent
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBack,
                        modifier = Modifier.testTag("study_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_button_desc)
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            onAskAiWithPrompt("Help me revise Class ${content.classNumber} ${content.subject.title} important concepts.")
                        },
                        modifier = Modifier.testTag("study_ask_ai_top_button")
                    ) {
                        Icon(
                            imageVector = Icons.Filled.AutoAwesome,
                            contentDescription = "Ask AI Tutor",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = visual.accent,
                modifier = Modifier.widthIn(max = 760.dp)
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.MenuBook, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Study Notes")
                        }
                    },
                    modifier = Modifier.testTag("tab_study_notes")
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Filled.Quiz, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Practice Quiz (${content.quiz.size})")
                        }
                    },
                    modifier = Modifier.testTag("tab_practice_quiz")
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .widthIn(max = 760.dp)
            ) {
                if (selectedTab == 0) {
                    StudyNotesList(
                        chapters = content.chapters,
                        accent = visual.accent,
                        softContainer = visual.softContainer,
                        completedChapters = completedChapters,
                        onToggleComplete = onToggleChapterComplete,
                        onAskAiWithPrompt = onAskAiWithPrompt
                    )
                } else {
                    InteractiveQuizPane(
                        questions = content.quiz,
                        accent = visual.accent,
                        bestScore = bestScore,
                        onQuizCompleted = onQuizCompleted,
                        onAskAiWithPrompt = onAskAiWithPrompt
                    )
                }
            }
        }
    }
}

@Composable
private fun StudyNotesList(
    chapters: List<StudyChapter>,
    accent: Color,
    softContainer: Color,
    completedChapters: Set<String>,
    onToggleComplete: (String) -> Unit,
    onAskAiWithPrompt: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(chapters, key = { it.id }) { chapter ->
            val isCompleted = completedChapters.contains(chapter.id)
            Card(
                shape = RoundedCornerShape(22.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                border = BorderStroke(
                    width = if (isCompleted) 1.5.dp else 1.dp,
                    color = if (isCompleted) QuizCorrect else MaterialTheme.colorScheme.outlineVariant
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = softContainer,
                            shape = CircleShape
                        ) {
                            Text(
                                text = "CHAPTER ${chapter.chapterNumber}",
                                style = MaterialTheme.typography.labelMedium,
                                color = accent,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }

                        if (isCompleted) {
                            Surface(color = QuizCorrectBg, shape = CircleShape) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.CheckCircle,
                                        contentDescription = null,
                                        tint = QuizCorrect,
                                        modifier = Modifier.size(14.dp)
                                    )
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Text(
                                        text = "Completed",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = QuizCorrect,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = chapter.title,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = chapter.summary,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "Key Takeaways",
                        style = MaterialTheme.typography.titleSmall,
                        color = accent,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    chapter.keyPoints.forEach { point ->
                        Row(
                            modifier = Modifier.padding(bottom = 6.dp),
                            verticalAlignment = Alignment.Top
                        ) {
                            Box(
                                modifier = Modifier
                                    .padding(top = 7.dp)
                                    .size(7.dp)
                                    .clip(CircleShape)
                                    .background(accent)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = point,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Surface(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = RoundedCornerShape(14.dp),
                        border = BorderStroke(1.dp, accent.copy(alpha = 0.25f)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(
                                text = "FORMULA / KEY RULE",
                                style = MaterialTheme.typography.labelSmall,
                                color = accent,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = chapter.formulaOrRule,
                                fontFamily = JetBrainsMonoFontFamily,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        OutlinedButton(
                            onClick = { onToggleComplete(chapter.id) },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("chapter_complete_${chapter.id}")
                        ) {
                            Icon(
                                imageVector = if (isCompleted) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                                contentDescription = null,
                                tint = if (isCompleted) QuizCorrect else MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(if (isCompleted) "Read" else "Mark Read")
                        }

                        Button(
                            onClick = { onAskAiWithPrompt(chapter.examplePrompt) },
                            colors = ButtonDefaults.buttonColors(containerColor = accent),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp)
                                .testTag("ask_ai_chapter_${chapter.id}")
                        ) {
                            Icon(
                                imageVector = Icons.Filled.AutoAwesome,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Ask AI")
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun InteractiveQuizPane(
    questions: List<QuizQuestion>,
    accent: Color,
    bestScore: Int?,
    onQuizCompleted: (Int) -> Unit,
    onAskAiWithPrompt: (String) -> Unit
) {
    var currentIndex by remember { mutableIntStateOf(0) }
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableIntStateOf(0) }
    var isFinished by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        if (bestScore != null) {
            item {
                Surface(
                    color = QuizCorrectBg,
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Filled.EmojiEvents, contentDescription = null, tint = QuizCorrect)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Your Personal Best: $bestScore / ${questions.size}",
                            style = MaterialTheme.typography.titleSmall,
                            color = QuizCorrect,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }

        if (isFinished) {
            item {
                Card(
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.5.dp, accent)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(72.dp)
                                .clip(CircleShape)
                                .background(accent.copy(alpha = 0.14f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.EmojiEvents,
                                contentDescription = null,
                                tint = accent,
                                modifier = Modifier.size(38.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(14.dp))
                        Text(
                            text = "Quiz Complete!",
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "You scored $score out of ${questions.size}",
                            style = MaterialTheme.typography.titleLarge,
                            color = accent,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = when {
                                score == questions.size -> "Shabaash! 100% Mastery — ready for exams!"
                                score >= (questions.size / 2) -> "Great effort! Revise the notes once more for a perfect score."
                                else -> "Good start! Review the Study Notes or ask AI Tutor for help."
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            OutlinedButton(
                                onClick = {
                                    currentIndex = 0
                                    selectedOption = null
                                    score = 0
                                    isFinished = false
                                },
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp)
                                    .testTag("quiz_retake_button")
                            ) {
                                Icon(Icons.Filled.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Retake")
                            }
                            Button(
                                onClick = {
                                    onAskAiWithPrompt("Give me 3 more practice MCQs with explanations for this chapter.")
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = accent),
                                shape = RoundedCornerShape(14.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp)
                                    .testTag("quiz_more_ai_button")
                            ) {
                                Icon(Icons.Filled.AutoAwesome, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("More with AI")
                            }
                        }
                    }
                }
            }
        } else {
            val question = questions[currentIndex]
            item {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Question ${currentIndex + 1} of ${questions.size}",
                            style = MaterialTheme.typography.labelLarge,
                            color = accent,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Score: $score",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { (currentIndex + 1).toFloat() / questions.size.toFloat() },
                        color = accent,
                        trackColor = accent.copy(alpha = 0.16f),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(CircleShape)
                    )
                }
            }

            item {
                Card(
                    shape = RoundedCornerShape(22.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = question.question,
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(modifier = Modifier.height(16.dp))

                        val optionLetters = listOf("A", "B", "C", "D")
                        question.options.forEachIndexed { idx, optionText ->
                            val isAnswered = selectedOption != null
                            val isSelected = selectedOption == idx
                            val isCorrect = idx == question.correctIndex

                            val bgColor = when {
                                !isAnswered -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.55f)
                                isCorrect -> QuizCorrectBg
                                isSelected && !isCorrect -> QuizWrongBg
                                else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
                            }
                            val borderColor = when {
                                !isAnswered -> MaterialTheme.colorScheme.outlineVariant
                                isCorrect -> QuizCorrect
                                isSelected && !isCorrect -> QuizWrong
                                else -> MaterialTheme.colorScheme.outlineVariant
                            }

                            Surface(
                                shape = RoundedCornerShape(14.dp),
                                color = bgColor,
                                border = BorderStroke(1.5.dp, borderColor),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp)
                                    .clip(RoundedCornerShape(14.dp))
                                    .clickable(enabled = !isAnswered) {
                                        selectedOption = idx
                                        if (idx == question.correctIndex) {
                                            score += 1
                                        }
                                    }
                                    .testTag("quiz_option_$idx")
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 14.dp, vertical = 14.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(28.dp)
                                            .clip(CircleShape)
                                            .background(
                                                when {
                                                    isAnswered && isCorrect -> QuizCorrect
                                                    isAnswered && isSelected -> QuizWrong
                                                    else -> accent.copy(alpha = 0.16f)
                                                }
                                            ),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            text = optionLetters.getOrElse(idx) { "${idx + 1}" },
                                            style = MaterialTheme.typography.labelMedium,
                                            color = if (isAnswered && (isCorrect || isSelected)) Color.White else accent,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        text = optionText,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        modifier = Modifier.weight(1f)
                                    )
                                    if (isAnswered && isCorrect) {
                                        Icon(Icons.Filled.CheckCircle, contentDescription = "Correct", tint = QuizCorrect)
                                    } else if (isAnswered && isSelected) {
                                        Icon(Icons.Filled.Close, contentDescription = "Incorrect", tint = QuizWrong)
                                    }
                                }
                            }
                        }

                        AnimatedVisibility(visible = selectedOption != null) {
                            Column {
                                Surface(
                                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f),
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(12.dp)) {
                                        Text(
                                            text = if (selectedOption == question.correctIndex) "Correct!" else "Explanation",
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(
                                            text = question.explanation,
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(14.dp))
                                Button(
                                    onClick = {
                                        if (currentIndex + 1 < questions.size) {
                                            currentIndex += 1
                                            selectedOption = null
                                        } else {
                                            isFinished = true
                                            onQuizCompleted(score)
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(containerColor = accent),
                                    shape = RoundedCornerShape(14.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp)
                                        .testTag("quiz_next_button")
                                ) {
                                    Text(
                                        text = if (currentIndex + 1 < questions.size) "Next Question" else "See Final Score",
                                        style = MaterialTheme.typography.labelLarge
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
