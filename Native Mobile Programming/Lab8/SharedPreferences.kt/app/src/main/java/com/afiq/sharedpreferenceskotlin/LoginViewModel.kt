package com.afiq.sharedpreferenceskotlin

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences: SharedPreferences by lazy {
        application.getSharedPreferences("login_data", Context.MODE_PRIVATE)
    }

    fun getCredentials(): Pair<String, String>? {
        val username = sharedPreferences.getString("username", null)
        val password = sharedPreferences.getString("password", null)
        return if (username != null && password != null) {
            Pair(username, password)
        } else {
            null
        }
    }

    fun saveSignUpData(username: String, password: String) {
        sharedPreferences.edit {
            if(username.isNotEmpty()&& username.isNotBlank()
                &&password.isNotEmpty()&& password.isNotBlank()){
                println("username =$username and password = $password")
                putString("username", username)
                putString("password", password)
            }else{
                println("LoginViewModel Data is Empty")
            }

        }
    }
    fun clearCredentials() {
        sharedPreferences.edit {
            remove("username")
            remove("password")
        }
    }


    class Factory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return LoginViewModel(application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

