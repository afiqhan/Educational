package com.afiq.lab6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Uses an implicit intent to make a call with the Phone app.
     * Gets the phone number from EditText editText_main.
     *
     * @param view View (phone_icon) that was clicked.
     */
    public void callNumber(View view) {
        EditText editText = findViewById(R.id.editText_main);
        // Use format with "tel:" and phone number to create phoneNumber.
        String phoneNumber = String.format("tel: %s", editText.getText().toString());

        // Log the concatenated phone number for dialing.
        Log.d(TAG, getString(R.string.dial_number) + phoneNumber);
        Toast.makeText(this,
                getString(R.string.dial_number) + phoneNumber,
                Toast.LENGTH_LONG).show();

        // Create the intent.
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        // Set the data for the intent as the phone number.
        callIntent.setData(Uri.parse(phoneNumber));

        // If package resolves to an app, send intent.
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_CALL Intent.");
        }
    }
}
