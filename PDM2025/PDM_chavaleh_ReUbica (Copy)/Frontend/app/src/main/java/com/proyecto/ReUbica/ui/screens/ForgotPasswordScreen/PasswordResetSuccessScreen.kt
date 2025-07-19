package com.proyecto.ReUbica.ui.screens.ForgotPasswordScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.proyecto.ReUbica.R
import com.proyecto.ReUbica.ui.navigations.LoginScreenNavigation

@Composable
fun PasswordResetSuccessScreen(navController: NavHostController) {
    val abel = FontFamily(Font(R.font.abelregular))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoreubica),
            contentDescription = "Logo"
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "¡Contraseña actualizada!",
            fontSize = 24.sp,
            fontFamily = abel,
            color = Color(0xFF49724C)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tu contraseña se cambió con éxito. Ahora puedes iniciar sesión.",
            fontSize = 16.sp,
            fontFamily = abel,
            color = Color(0xFF5A3C1D)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(LoginScreenNavigation) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF49724C))
        ) {
            Text("Iniciar sesión", fontFamily = abel, color = Color.White)
        }
    }
}
