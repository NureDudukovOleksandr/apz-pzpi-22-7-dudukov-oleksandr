package com.example.apz111.features.presence

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apz111.viewmodel.PresenceViewModel

@Composable
fun PresenceScreen(token: String, viewModel: PresenceViewModel = hiltViewModel()) {
    var message by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = {
            viewModel.markPresence(token) {
                message = it
            }
        }) {
            Text("Я на місці")
        }
        if (message.isNotEmpty()) {
            Text(text = message, modifier = Modifier.padding(top = 8.dp))
        }
    }
}