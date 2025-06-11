package com.example.apz111.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.apz111.features.auth.AuthScreen
import com.example.apz111.features.dashboard.DashboardScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Auth.route) {
        composable(Screen.Auth.route) {
            AuthScreen(navController)
        }
        composable(Screen.Dashboard.route) {
            DashboardScreen()
        }
    }
}
