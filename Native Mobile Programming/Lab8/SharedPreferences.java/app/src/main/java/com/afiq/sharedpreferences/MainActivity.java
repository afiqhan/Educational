//author : afiq hanif (S62993)

package com.afiq.sharedpreferences;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    //main screen components
    TextView tvWelcome;
    Button btnLogout;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(
                this,
                new LoginViewModel.Factory(getApplication())
        ).get(LoginViewModel.class);
        View view = findViewById(android.R.id.content);
        tvWelcome = (TextView) findViewById(R.id.tvWelcome);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        Pair<String, String> userData = viewModel.getCredentials();
        if (userData != null) {
            String username = userData.first;
            Log.d("MainActivity", String.format("userData would equal to %S", username));
            Snackbar.make(view , String.format("Hello %S",username), Snackbar.LENGTH_LONG).show();
            tvWelcome.setText(String.format("Welcome %S", username));
            btnLogout.setOnClickListener(v -> {
                viewModel.clearData();

                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                Snackbar.make(view , String.format("Bye Bye %S",username), Snackbar.LENGTH_LONG).show();
            });
        } else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
    }

}



