package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Translate
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.SchoolStage
import com.example.data.model.SubjectType
import com.example.ui.theme.EmeraldTeal
import com.example.ui.theme.EnglishAccent
import com.example.ui.theme.EnglishSurface
import com.example.ui.theme.HindiAccent
import com.example.ui.theme.HindiSurface
import com.example.ui.theme.MathAccent
import com.example.ui.theme.MathSurface
import com.example.ui.theme.ProGold
import com.example.ui.theme.ProMidnight
import com.example.ui.theme.ProMidnightEnd
import com.example.ui.theme.RoyalIndigo
import com.example.ui.theme.SaffronOrange
import com.example.ui.theme.ScienceAccent
import com.example.ui.theme.ScienceSurface

data class SubjectVisual(
    val accent: Color,
    val softContainer: Color,
    val icon: ImageVector
)

fun subjectVisual(subject: SubjectType): SubjectVisual = when (subject) {
    SubjectType.MATH -> SubjectVisual(MathAccent, MathSurface, Icons.Filled.Calculate)
    SubjectType.SCIENCE -> SubjectVisual(ScienceAccent, ScienceSurface, Icons.Filled.Science)
    SubjectType.HINDI -> SubjectVisual(HindiAccent, HindiSurface, Icons.Filled.Translate)
    SubjectType.ENGLISH -> SubjectVisual(EnglishAccent, EnglishSurface, Icons.Filled.AutoStories)
}

fun stageAccentColor(classNumber: Int): Color = when (SchoolStage.forClass(classNumber)) {
    SchoolStage.PRIMARY -> SaffronOrange
    SchoolStage.MIDDLE -> EmeraldTeal
    SchoolStage.SECONDARY -> RoyalIndigo
    SchoolStage.SENIOR_SECONDARY -> EnglishAccent
}

@Composable
fun PhotoSolverBannerCard(
    onOpenPhotoChatClick: () -> Unit,
    modifier: Modifier = Modifier,
    testTag: String = "home_photo_solver_button"
) {
    val gradient = Brush.linearGradient(
        colors = listOf(ProMidnight, ProMidnightEnd, Color(0xFF4338CA))
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(22.dp))
            .background(gradient)
            .clickable(onClick = onOpenPhotoChatClick)
            .padding(18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = null,
                        tint = ProGold,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "PHOTO DOUBT SOLVER • FREE",
                        style = MaterialTheme.typography.labelMedium,
                        color = ProGold,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Snap & Solve Math/Science Questions",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Upload or capture any notebook or textbook question for step-by-step AI solutions.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.84f)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = onOpenPhotoChatClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ProGold,
                        contentColor = ProMidnight
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.testTag(testTag)
                ) {
                    Icon(
                        imageVector = Icons.Filled.AutoAwesome,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Open Photo Solver",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    }
}
