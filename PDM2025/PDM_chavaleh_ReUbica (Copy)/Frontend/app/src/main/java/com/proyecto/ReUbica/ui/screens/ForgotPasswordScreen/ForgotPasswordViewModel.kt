package com.proyecto.ReUbica.ui.screens.ForgotPasswordScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proyecto.ReUbica.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel : ViewModel() {
    private var lastEmail: String? = null
    private var lastCode: String? = null

    private val userRepository = UserRepository()

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _success = MutableStateFlow(false)
    val success: StateFlow<Boolean> = _success

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun sendResetCode(email: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            _success.value = false

            try {
                val response = userRepository.sendResetCode(email)
                if (response.isSuccessful) {
                    lastEmail = email
                    _success.value = true
                } else {
                    _error.value = response.errorBody()?.string() ?: "Error desconocido"
                }
            } catch (e: Exception) {
                _error.value = "Error de conexión: ${e.localizedMessage}"
            } finally {
                _loading.value = false
            }
        }
    }

    fun setResetData(email: String) {
        lastEmail = email
    }
    fun verifyResetCode(code: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            lastCode = code

            if (code.isNotBlank() && code.length == 6) {
                _success.value = true
            } else {
                _error.value = "Código inválido"
            }

            _loading.value = false
        }
    }

    fun submitNewPassword(code: String, newPassword: String, confirmPassword: String) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            _success.value = false

            try {
                val response = userRepository.resetPassword(
                    email = lastEmail ?: "",
                    code = code,
                    newPassword = newPassword,
                    confirmNewPassword = confirmPassword
                )

                if (response.isSuccessful) {
                    _success.value = true
                } else {
                    _error.value = response.errorBody()?.string() ?: "Error desconocido"
                }
            } catch (e: Exception) {
                _error.value = "Error de conexión: ${e.localizedMessage}"
            } finally {
                _loading.value = false
            }
        }
    }
}
