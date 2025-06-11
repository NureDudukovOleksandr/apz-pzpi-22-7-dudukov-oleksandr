package com.example.apz111.navigation



sealed class Screen(val route: String) {
    object Auth : Screen("auth_screen")
    object Dashboard : Screen("dashboard_screen")
}