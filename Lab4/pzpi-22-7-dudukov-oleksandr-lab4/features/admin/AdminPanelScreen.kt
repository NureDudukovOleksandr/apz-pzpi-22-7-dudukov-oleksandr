package com.example.apz111.features.admin

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.apz111.viewmodel.AdminViewModel
import com.example.apz111.data.model.User

@Composable
fun AdminPanelScreen(token: String, viewModel: AdminViewModel = hiltViewModel()) {
    val users by viewModel.users.collectAsState()

    LaunchedEffect(true) {
        viewModel.loadUsers(token)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Керування користувачами", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(users) { user ->
                UserItem(user = user, onRoleChange = {
                    viewModel.updateUserRole(token, user.id, it)
                })
                Divider()
            }
        }
    }
}

@Composable
fun UserItem(user: User, onRoleChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = user.name)
            Text(text = "Роль: ${user.role}")
        }
        Button(onClick = {
            val newRole = if (user.role == "user") "admin" else "user"
            onRoleChange(newRole)
        }) {
            Text("Змінити роль")
        }
    }
}
