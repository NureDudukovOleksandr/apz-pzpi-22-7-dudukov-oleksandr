package com.example.apz111

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.apz111.navigation.AppNavigation
import com.example.apz111.ui.theme.Apz111Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Apz111Theme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}