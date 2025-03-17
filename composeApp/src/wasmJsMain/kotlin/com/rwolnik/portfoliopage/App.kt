package com.rwolnik.portfoliopage

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    MaterialTheme {

            MaterialTheme {
//                NavHost(navController = rememberNavController(), startDestination = "home") {
//                    composable("home") { HomeScreen() }
//                    composable("projects") { ProjectsScreen() }
//                }

        }
    }
}

@Preview()
@Composable
fun AppPreview(){
    App()
}