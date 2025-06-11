// 📁 viewmodel/AdminViewModel.kt
package com.example.apz111.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apz111.data.model.User
import com.example.apz111.data.repository.OfficeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminViewModel @Inject constructor(
    private val repository: OfficeRepository
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    fun loadUsers(token: String) {
        viewModelScope.launch {
            try {
                _users.value = repository.getAllUsers(token)
            } catch (e: Exception) {
                // Лог або обробка помилок
            }
        }
    }

    fun updateUserRole(token: String, userId: String, newRole: String) {
        viewModelScope.launch {
            try {
                repository.updateUserRole(token, userId, newRole)
                loadUsers(token) // оновлюємо список
            } catch (e: Exception) {
                // Лог або обробка помилок
            }
        }
    }
}
