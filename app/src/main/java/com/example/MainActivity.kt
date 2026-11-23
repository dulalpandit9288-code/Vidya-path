package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.data.ai.DoubtSolverRepository
import com.example.data.ai.configureAppCheck
import com.example.data.curriculum.CurriculumRepository
import com.example.data.preferences.UserPreferencesRepository
import com.example.ui.navigation.VidyaPathApp
import com.example.ui.theme.VidyaPathTheme
import com.example.ui.viewmodel.DoubtSolverViewModel
import com.example.ui.viewmodel.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure Firebase App Check before any UI, ViewModels, or Firebase AI calls
        configureAppCheck(this, intent)

        enableEdgeToEdge()

        val prefsRepository = UserPreferencesRepository(applicationContext)
        val curriculumRepository = CurriculumRepository()
        val doubtRepository = DoubtSolverRepository()

        val homeViewModel = ViewModelProvider(
            this,
            HomeViewModel.Factory(curriculumRepository, prefsRepository)
        )[HomeViewModel::class.java]

        val doubtViewModel = ViewModelProvider(
            this,
            DoubtSolverViewModel.Factory(doubtRepository)
        )[DoubtSolverViewModel::class.java]

        setContent {
            VidyaPathTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    VidyaPathApp(
                        homeViewModel = homeViewModel,
                        doubtViewModel = doubtViewModel
                    )
                }
            }
        }
    }
}
