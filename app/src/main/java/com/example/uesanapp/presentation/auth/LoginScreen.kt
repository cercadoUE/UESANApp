package com.example.uesanapp.presentation.auth

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uesanapp.data.remote.FirebaseAuthManager
import kotlinx.coroutines.launch


@Composable

fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Iniciar Sesion",
            style = MaterialTheme.typography.titleLarge
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo Electronico") },
            placeholder = { Text("Correo Electronico") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            placeholder = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        val scope = rememberCoroutineScope()
        val context = LocalContext.current

        Button(
            onClick = {
                if (email.isNotBlank() && password.isNotBlank()) {

                    scope.launch {
                        val result = FirebaseAuthManager
                            .loginUser(email, password)

                        result.onSuccess {
                            Toast.makeText(
                                context,
                                "Login exitoso",
                                Toast.LENGTH_SHORT
                            ).show()

                            navController.navigate("home")
                        }

                        result.onFailure {
                            Toast.makeText(
                                context,
                                "Error: ${it.message}",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                } else {
                    Toast.makeText(
                        context,
                        "Completa los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text("¿No tienes cuenta? Regístrate aquí")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate("register") }) {
            Text("¿No tienes cuenta? Regístrate aquí")
        }

    }

}