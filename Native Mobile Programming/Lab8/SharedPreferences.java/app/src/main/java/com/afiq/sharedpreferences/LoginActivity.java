package com.afiq.sharedpreferences;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    // login screen component
    EditText etUsername ;
    EditText etPassword ;

    Button btnLogin ;
    Button btnSignUp ;
    LoginViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        viewModel = new ViewModelProvider(
                this,
                new LoginViewModel.Factory(getApplication())
        ).get(LoginViewModel.class);
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(login);
        btnSignUp.setOnClickListener(signup);

    }
    OnClickListener login = new OnClickListener() {
        @Override
        public void onClick(View v){
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if(viewModel.getCredentials() != null){
                if((!username.isEmpty()&& username.equals(viewModel.getCredentials().first)) &&
                        (!password.isEmpty() && password.equals(viewModel.getCredentials().second))){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    Snackbar.make(v , String.format("%S Login Successfully",username), Snackbar.LENGTH_LONG).show();
                }else{
                    Log.d("LoginActivity","check username or email");
                    Snackbar.make(v, "check username or email", Snackbar.LENGTH_LONG).show();

                }

            }else{
                Log.d("LoginActivity","There is no username or password in shared memory");
                Snackbar.make(v, "There is no username or password in shared memory", Snackbar.LENGTH_LONG).show();

            }

        }
    };
    OnClickListener signup = new OnClickListener() {

        @Override
        public void onClick(View v){
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            if(!username.isEmpty() && !password.isEmpty()){
                viewModel.saveData(username, password);
                Snackbar.make(v , String.format("%S Sign up Successfully",username), Snackbar.LENGTH_LONG).show();
            }else{
                Log.d("LoginActivity","Can not save empty values");
                Snackbar.make(v, "Username or Password can not be empty", Snackbar.LENGTH_LONG).show();

            }
        }
    };
}
