package com.afiq.sharedpreferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class LoginViewModel extends AndroidViewModel {
    private final SharedPreferences sharedPreferences;
    public LoginViewModel(@NonNull Application application) {
        super(application);
        sharedPreferences = application.getSharedPreferences("user_data", Context.MODE_PRIVATE);
    }
    public Pair<String, String> getCredentials(){
        String username = sharedPreferences.getString("username",null);
        String password = sharedPreferences.getString("password",null);
    return (username !=null && password!= null)?new Pair<>(username,password):null;
    }

    public void saveData(String username, String password){
        if((!username.isEmpty())&&(!password.isEmpty())){
            sharedPreferences.edit().putString("username", username).apply();
            sharedPreferences.edit().putString("password",password).apply();
        }else{
            System.out.println("LoginViewModel Can not save empty string");
        }
    }
    public void clearData(){
        sharedPreferences.edit().remove("username").remove("password").apply();
    }

    public static class Factory implements ViewModelProvider.Factory{
        private final Application application;

        public Factory(Application application){
            this.application = application;
        }

        @NonNull
        @Override
        public <T extends ViewModel>T create(@NonNull Class<T> modelClass){
            if(modelClass.isAssignableFrom(LoginViewModel.class)){
                return (T) new LoginViewModel(application);
            }
            throw new IllegalArgumentException();
        }
    }
}
