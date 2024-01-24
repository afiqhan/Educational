package com.afiq.sharedpreferenceskotlin

import android.graphics.Paint.Align
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.afiq.sharedpreferenceskotlin.ui.theme.SharedPreferencesKotlinTheme

class MainActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: LoginViewModel = ViewModelProvider(
                this,
                LoginViewModel.Factory(application)
            ).get(LoginViewModel::class.java)
            val credentials = viewModel.getCredentials()

            if (credentials != null) {
                SuccessScreen(
                    credentials.first,
                    credentials.second,
                    onLogout = {
                        viewModel.clearCredentials()  // Add a function to clear credentials in the ViewModel
                        setContent {
                            LoginScreen(
                                onLogin = { username, password ->
                                    val userData = viewModel.getCredentials()
                                    if (userData != null && userData.first == username && userData.second == password) {
                                        setContent {
                                            SuccessScreen(
                                                username,
                                                password,
                                                onLogout = { viewModel.clearCredentials() }) // Optionally, navigate to success screen again
                                        }
                                    } else {
                                        println("UserData is not matched with the saved data")
                                    }
                                },
                                onSignUp = { username, password ->
                                    if (username.isNotBlank() && username.isNotEmpty() && password.isNotBlank() && password.isNotEmpty()) {
                                        viewModel.saveSignUpData(username, password)
                                    } else {
                                        println("UserData is empty")
                                    }
                                }
                            )
                        }
                    }
                )
            } else {
                LoginScreen(
                    onLogin = { username, password ->
                        val userData = viewModel.getCredentials()
                        if (userData != null && userData.first == username && userData.second == password) {
                            setContent {
                                SuccessScreen(username, password, onLogout = {
                                    viewModel.clearCredentials()
                                    setContent {
                                        LoginScreen(
                                            onLogin = { username, password ->
                                                val userData = viewModel.getCredentials()
                                                if (userData != null && userData.first == username && userData.second == password) {
                                                    setContent {
                                                        SuccessScreen(
                                                            username,
                                                            password,
                                                            onLogout = { viewModel.clearCredentials() }) // Optionally, navigate to success screen again
                                                    }
                                                } else {
                                                    println("UserData is not matched with the saved data")
                                                }
                                            },
                                            onSignUp = { username, password ->
                                                if (username.isNotBlank() && username.isNotEmpty() && password.isNotBlank() && password.isNotEmpty()) {
                                                    viewModel.saveSignUpData(username, password)
                                                } else {
                                                    println("UserData is empty")
                                                }
                                            }
                                        )
                                    }
                                })
                            }
                        } else {
                            println("UserData is not matched with the saved data")
                        }
                    },
                    onSignUp = { username, password ->
                        if (username.isNotBlank() && username.isNotEmpty() && password.isNotBlank() && password.isNotEmpty()) {
                            viewModel.saveSignUpData(username, password)
                        } else {
                            println("UserData is empty")
                        }
                    }
                )
            }
        }
    }
}

// LoginActivity.kt
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onLogin: (String, String) -> Unit, onSignUp: (String, String) -> Unit) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.user_instructions),
            modifier = Modifier.padding(vertical = 24.dp),
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            color = Color.Red

        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Button(
            onClick = { onLogin(username, password) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Login")
        }
        Button(
            onClick = { onSignUp(username, password) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Sign Up")
        }
    }
}

@Composable
fun SuccessScreen(username: String, password: String, onLogout: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Login Successful", color = Color.White, fontSize = 24.sp)
            Text("Welcome ${username.toUpperCase()}", color = Color.White, fontSize = 20.sp)

            // Logout Button
            Button(
                onClick = onLogout,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text("Logout")
            }
        }
    }
}