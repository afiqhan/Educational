package com.afiq.lab6;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Uses an implicit intent to dial the phone with the Phone app.
     * Gets the phone number from TextView number_to_call.
     *
     * @param view View (phone_icon) that was clicked.
     */
    public void dialNumber(View view) {
        TextView textView = (TextView) findViewById(R.id.number_to_call);
        // Use format with "tel:" and phone number to create phoneNumber.
        String phoneNumber = String.format("tel: %s", textView.getText().toString());
        // Create the intent.
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        // Set the data for the intent as the phone number.
        callIntent.setData(Uri.parse(phoneNumber));
        // If package resolves to an app, send intent.
        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        } else {
            Log.e(TAG, "Can't resolve app for ACTION_DIAL Intent.");
        }
    }

    /**
     * Uses an implicit intent to send a message with an SMS messaging app.
     * Gets the phone number from TextView number_to_call.
     *
     * @param view View (message_icon) that was clicked.
     */
    public void smsSendMessage(View view) {
        TextView textView = findViewById(R.id.number_to_call);
        String smsNumber = String.format("smsto:%s", textView.getText().toString());

        EditText smsEditText = findViewById(R.id.sms_message);
        String sms = smsEditText.getText().toString();

        Intent smsIntent = new Intent(Intent.ACTION_SEND);
        smsIntent.setType("text/plain");
        smsIntent.putExtra(Intent.EXTRA_TEXT, sms);
        smsIntent.putExtra("address", smsNumber);

        if (smsIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(smsIntent);
        } else {
            Log.d(TAG, "Can't resolve app for ACTION_SEND Intent");
        }
    }
}