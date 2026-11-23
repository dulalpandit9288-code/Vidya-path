package com.example.ui.navigation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.R
import com.example.data.model.ChatMode
import com.example.data.model.SubjectType
import com.example.ui.screens.DoubtSolverScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.StudyAndQuizScreen
import com.example.ui.screens.SubjectsScreen
import com.example.ui.viewmodel.DoubtSolverViewModel
import com.example.ui.viewmodel.HomeViewModel

private object Routes {
    const val HOME = "learn_home"
    const val SUBJECTS = "subjects/{classNumber}"
    const val STUDY = "study/{classNumber}/{subjectName}"
    const val DOUBT_SOLVER = "doubt_solver"

    fun subjects(classNumber: Int) = "subjects/$classNumber"
    fun study(classNumber: Int, subject: SubjectType) = "study/$classNumber/${subject.name}"
}

private data class TopDestination(
    val route: String,
    val labelRes: Int,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val testTag: String
)

private val topDestinations = listOf(
    TopDestination(
        route = Routes.HOME,
        labelRes = R.string.nav_learn,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        testTag = "nav_learn"
    ),
    TopDestination(
        route = Routes.DOUBT_SOLVER,
        labelRes = R.string.nav_doubts,
        selectedIcon = Icons.Filled.AutoAwesome,
        unselectedIcon = Icons.Outlined.AutoAwesome,
        testTag = "nav_doubts"
    )
)

@Composable
fun VidyaPathApp(
    homeViewModel: HomeViewModel,
    doubtViewModel: DoubtSolverViewModel
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val selectedClass by homeViewModel.selectedClass.collectAsStateWithLifecycle()
    val completedChapters by homeViewModel.completedChapters.collectAsStateWithLifecycle()
    val quizBestScores by homeViewModel.quizBestScores.collectAsStateWithLifecycle()
    val doubtUiState by doubtViewModel.uiState.collectAsStateWithLifecycle()

    val showTopLevelNav = currentRoute in listOf(
        Routes.HOME,
        Routes.DOUBT_SOLVER
    )

    fun navigateTopLevel(route: String) {
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useRail = maxWidth >= 600.dp

        Scaffold(
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            containerColor = MaterialTheme.colorScheme.background,
            bottomBar = {
                if (showTopLevelNav && !useRail) {
                    NavigationBar {
                        topDestinations.forEach { dest ->
                            val selected = currentRoute == dest.route
                            val label = stringResource(dest.labelRes)
                            NavigationBarItem(
                                selected = selected,
                                onClick = { navigateTopLevel(dest.route) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = label
                                    )
                                },
                                label = { Text(label) },
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (showTopLevelNav && useRail) {
                    NavigationRail(modifier = Modifier.fillMaxHeight()) {
                        topDestinations.forEach { dest ->
                            val selected = currentRoute == dest.route
                            val label = stringResource(dest.labelRes)
                            NavigationRailItem(
                                selected = selected,
                                onClick = { navigateTopLevel(dest.route) },
                                icon = {
                                    Icon(
                                        imageVector = if (selected) dest.selectedIcon else dest.unselectedIcon,
                                        contentDescription = label
                                    )
                                },
                                label = { Text(label) },
                                modifier = Modifier.testTag(dest.testTag)
                            )
                        }
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = Routes.HOME,
                    modifier = Modifier.weight(1f)
                ) {
                    composable(Routes.HOME) {
                        HomeScreen(
                            selectedClass = selectedClass,
                            completedChaptersCount = completedChapters.size,
                            quizzesCompletedCount = quizBestScores.size,
                            onClassClick = { cls ->
                                homeViewModel.selectClass(cls)
                                navController.navigate(Routes.subjects(cls))
                            },
                            onOpenDoubtSolver = {
                                doubtViewModel.setContext(selectedClass, SubjectType.MATH)
                                doubtViewModel.setMode(ChatMode.TEXT_CHAT)
                                navigateTopLevel(Routes.DOUBT_SOLVER)
                            },
                            onOpenPhotoSolver = {
                                doubtViewModel.setContext(selectedClass, SubjectType.MATH)
                                doubtViewModel.setMode(ChatMode.PHOTO_SOLVER)
                                navigateTopLevel(Routes.DOUBT_SOLVER)
                            }
                        )
                    }

                    composable(
                        route = Routes.SUBJECTS,
                        arguments = listOf(navArgument("classNumber") { type = NavType.IntType })
                    ) { entry ->
                        val classNumber = entry.arguments?.getInt("classNumber") ?: 10
                        val subjects = homeViewModel.getSubjectsForClass(classNumber)
                        SubjectsScreen(
                            classNumber = classNumber,
                            subjects = subjects,
                            completedChapters = completedChapters,
                            quizBestScores = quizBestScores,
                            onBack = { navController.popBackStack() },
                            onSubjectClick = { subject ->
                                navController.navigate(Routes.study(classNumber, subject))
                            },
                            onAskClassDoubt = {
                                doubtViewModel.setContext(classNumber, SubjectType.MATH)
                                navigateTopLevel(Routes.DOUBT_SOLVER)
                            }
                        )
                    }

                    composable(
                        route = Routes.STUDY,
                        arguments = listOf(
                            navArgument("classNumber") { type = NavType.IntType },
                            navArgument("subjectName") { type = NavType.StringType }
                        )
                    ) { entry ->
                        val classNumber = entry.arguments?.getInt("classNumber") ?: 10
                        val subject = SubjectType.fromName(entry.arguments?.getString("subjectName"))
                        val content = homeViewModel.getSubjectContent(classNumber, subject)
                        val bestScore = quizBestScores["${classNumber}_${subject.name}"]

                        StudyAndQuizScreen(
                            content = content,
                            completedChapters = completedChapters,
                            bestScore = bestScore,
                            onBack = { navController.popBackStack() },
                            onToggleChapterComplete = { chapterId ->
                                homeViewModel.toggleChapterCompleted(chapterId)
                            },
                            onQuizCompleted = { score ->
                                homeViewModel.saveQuizScore(classNumber, subject, score)
                            },
                            onAskAiWithPrompt = { prompt ->
                                doubtViewModel.prefillTopicPrompt(classNumber, subject, prompt)
                                navigateTopLevel(Routes.DOUBT_SOLVER)
                            }
                        )
                    }

                    composable(Routes.DOUBT_SOLVER) {
                        DoubtSolverScreen(
                            uiState = doubtUiState,
                            onModeChange = doubtViewModel::setMode,
                            onContextChange = doubtViewModel::setContext,
                            onTextInputChange = doubtViewModel::updateTextInput,
                            onSendTextDoubt = doubtViewModel::sendTextQuestion,
                            onRetryTextDoubt = doubtViewModel::retryLastTextQuestion,
                            onClearChat = doubtViewModel::clearChatHistory,
                            onPhotoSelected = doubtViewModel::setSelectedPhotoUri,
                            onPhotoHintChange = doubtViewModel::updatePhotoHintInput,
                            onSolvePhotoDoubt = doubtViewModel::solvePhotoDoubt
                        )
                    }
                }
            }
        }
    }
}
