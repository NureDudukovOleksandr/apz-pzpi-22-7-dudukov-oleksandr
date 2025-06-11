package com.example.apz111.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apz111.data.repository.OfficeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class PresenceViewModel @Inject constructor(
    private val repository: OfficeRepository
) : ViewModel() {

    fun markPresence(token: String, onResult: (String) -> Unit) {
        viewModelScope.launch {
            try {
                repository.markPresence(token)
                onResult("Присутність відмічено")
            } catch (e: Exception) {
                onResult("Помилка: ${e.message}")
            }
        }
    }
}