package com.example.apz111.features.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Моніторинг працездатності офісу") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Text("👩‍💼 Стан співробітників: Усі в нормі")
            Spacer(modifier = Modifier.height(16.dp))
            Text("💻 Системи: Сервери працюють стабільно")
            Spacer(modifier = Modifier.height(16.dp))
            Text("📡 Інтернет-з'єднання: Онлайн")
            Spacer(modifier = Modifier.height(16.dp))
            Text("🧊 Кондиціювання: Температура в межах норми")
        }
    }
}