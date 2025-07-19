package com.proyecto.ReUbica.ui.screens.ForgotPasswordScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.proyecto.ReUbica.R
import com.proyecto.ReUbica.ui.navigations.PasswordResetSuccessNavigation

@Composable
fun ResetNewPasswordScreen(
    navController: NavHostController,
    viewModel: ForgotPasswordViewModel = viewModel()
) {
    val abel = FontFamily(Font(R.font.abelregular))

    var code by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scrollState = rememberScrollState()

    val loading by viewModel.loading.collectAsState()
    val success by viewModel.success.collectAsState()
    val error by viewModel.error.collectAsState()

    val isCodeValid = code.length == 6

    if (success) {
        LaunchedEffect(success) {
            navController.navigate(PasswordResetSuccessNavigation)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(R.drawable.logoreubica),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Nueva contraseña",
            color = Color(0xFF5A3C1D),
            fontSize = 26.sp,
            fontFamily = abel
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Ingresa el código enviado por correo y tu nueva contraseña. La contraseña debe tener al menos 8 caracteres, incluyendo una mayúscula, un número y un símbolo.",
            color = Color(0xFF5A3C1D),
            fontSize = 16.sp,
            fontFamily = abel
        )

        Spacer(modifier = Modifier.height(28.dp))

        TextField(
            value = code,
            onValueChange = { code = it },
            placeholder = {
                Text("Código recibido por correo", fontFamily = abel, color = Color.Black.copy(alpha = 0.5f))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = LocalTextStyle.current.copy(color = Color.Black, fontFamily = abel),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFDFF2E1),
                unfocusedContainerColor = Color(0xFFDFF2E1),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            placeholder = {
                Text("Nueva contraseña", fontFamily = abel, color = Color.Black.copy(alpha = 0.5f))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            textStyle = LocalTextStyle.current.copy(color = Color.Black, fontFamily = abel),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFDFF2E1),
                unfocusedContainerColor = Color(0xFFDFF2E1),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = {
                Text("Confirmar contraseña", fontFamily = abel, color = Color.Black.copy(alpha = 0.5f))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            textStyle = LocalTextStyle.current.copy(color = Color.Black, fontFamily = abel),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFDFF2E1),
                unfocusedContainerColor = Color(0xFFDFF2E1),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth()
        )

        errorMessage?.let {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = it, color = Color.Red, fontFamily = abel)
        }

        if (error != null) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = error!!, color = Color.Red, fontFamily = abel)
        }

        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = {
                if (code.length != 6) {
                    errorMessage = "El código debe tener 6 dígitos"
                } else if (newPassword.length < 8 ||
                    !newPassword.any { it.isUpperCase() } ||
                    !newPassword.any { it.isDigit() } ||
                    !newPassword.any { !it.isLetterOrDigit() }
                ) {
                    errorMessage = "La contraseña debe tener mínimo 8 caracteres, una mayúscula, un número y un símbolo."
                } else if (newPassword != confirmPassword) {
                    errorMessage = "Las contraseñas no coinciden"
                } else {
                    errorMessage = null
                    viewModel.submitNewPassword(code, newPassword, confirmPassword)
                }
            },
            enabled=isCodeValid,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF49724C)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            Text("Actualizar contraseña", fontFamily = abel, color = Color.White, fontSize = 18.sp)
        }
    }
}
