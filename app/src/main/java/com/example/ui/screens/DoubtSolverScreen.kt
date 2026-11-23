package com.example.ui.screens

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.DeleteOutline
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.ChatMode
import com.example.data.model.SubjectType
import com.example.ui.theme.ProGold
import com.example.ui.theme.ProMidnightEnd
import com.example.ui.viewmodel.DoubtSolverUiState

@Composable
fun DoubtSolverScreen(
    uiState: DoubtSolverUiState,
    onModeChange: (ChatMode) -> Unit,
    onContextChange: (Int, SubjectType) -> Unit,
    onTextInputChange: (String) -> Unit,
    onSendTextDoubt: (String?) -> Unit,
    onRetryTextDoubt: () -> Unit,
    onClearChat: () -> Unit,
    onPhotoSelected: (Uri?) -> Unit,
    onPhotoHintChange: (String) -> Unit,
    onSolvePhotoDoubt: (Context) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .widthIn(max = 840.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "AI Doubt Solver",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Instant NCERT & Board Solutions",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                if (uiState.activeMode == ChatMode.TEXT_CHAT && uiState.messages.isNotEmpty()) {
                    IconButton(
                        onClick = onClearChat,
                        modifier = Modifier.testTag("clear_chat_button")
                    ) {
                        Icon(
                            imageVector = Icons.Filled.DeleteOutline,
                            contentDescription = "Clear chat"
                        )
                    }
                }
            }

            ModeSegmentedBar(
                activeMode = uiState.activeMode,
                onModeSelected = onModeChange,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            ClassSubjectContextStrip(
                selectedClass = uiState.selectedClass,
                selectedSubject = uiState.selectedSubject,
                onContextChange = onContextChange
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (uiState.activeMode == ChatMode.TEXT_CHAT) {
                FreeTextChatPane(
                    uiState = uiState,
                    onTextInputChange = onTextInputChange,
                    onSendClick = { onSendTextDoubt(null) },
                    onQuickPromptClick = { prompt -> onSendTextDoubt(prompt) },
                    onRetryClick = onRetryTextDoubt,
                    modifier = Modifier.weight(1f)
                )
            } else {
                PhotoSolverPane(
                    uiState = uiState,
                    onPhotoSelected = onPhotoSelected,
                    onPhotoHintChange = onPhotoHintChange,
                    onSolvePhotoClick = { onSolvePhotoDoubt(context) },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun ModeSegmentedBar(
    activeMode: ChatMode,
    onModeSelected: (ChatMode) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            val isTextMode = activeMode == ChatMode.TEXT_CHAT
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (isTextMode) MaterialTheme.colorScheme.surface else Color.Transparent,
                shadowElevation = if (isTextMode) 2.dp else 0.dp,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onModeSelected(ChatMode.TEXT_CHAT) }
                    .testTag("mode_text_chat")
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.ChatBubbleOutline,
                        contentDescription = null,
                        tint = if (isTextMode) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Text Chat",
                        style = MaterialTheme.typography.labelLarge,
                        color = if (isTextMode) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            val isPhotoMode = activeMode == ChatMode.PHOTO_SOLVER
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = if (isPhotoMode) ProMidnightEnd else Color.Transparent,
                shadowElevation = if (isPhotoMode) 2.dp else 0.dp,
                modifier = Modifier
                    .weight(1f)
                    .height(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onModeSelected(ChatMode.PHOTO_SOLVER) }
                    .testTag("mode_photo_solver")
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = null,
                        tint = if (isPhotoMode) ProGold else MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.size(17.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Photo Solver",
                        style = MaterialTheme.typography.labelLarge,
                        color = if (isPhotoMode) Color.White else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun ClassSubjectContextStrip(
    selectedClass: Int,
    selectedSubject: SubjectType,
    onContextChange: (Int, SubjectType) -> Unit
) {
    var classMenuExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            FilterChip(
                selected = true,
                onClick = { classMenuExpanded = true },
                label = { Text("Class $selectedClass") },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ExpandMore,
                        contentDescription = "Choose class",
                        modifier = Modifier.size(16.dp)
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
            DropdownMenu(
                expanded = classMenuExpanded,
                onDismissRequest = { classMenuExpanded = false }
            ) {
                (1..12).forEach { cls ->
                    DropdownMenuItem(
                        text = { Text("Class $cls") },
                        onClick = {
                            onContextChange(cls, selectedSubject)
                            classMenuExpanded = false
                        }
                    )
                }
            }
        }

        SubjectType.entries.forEach { subject ->
            FilterChip(
                selected = selectedSubject == subject,
                onClick = { onContextChange(selectedClass, subject) },
                label = { Text(subject.title) }
            )
        }
    }
}
