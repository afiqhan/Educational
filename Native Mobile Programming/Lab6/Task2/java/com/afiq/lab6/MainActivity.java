package com.afiq.lab6;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.telephony.PhoneStateListener;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TelephonyManager mTelephonyManager;
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    private MyPhoneCallListener mListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTelephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

        if (isTelephonyEnabled()) {
            Log.d(TAG, "Telephony is enabled");
            checkForPhonePermission();
            mListener = new MyPhoneCallListener();
            mTelephonyManager.listen(mListener, PhoneStateListener.LISTEN_CALL_STATE);
        } else {
            Toast.makeText(this, "TELEPHONY NOT ENABLED! ", Toast.LENGTH_LONG).show();
            Log.d(TAG, "TELEPHONY NOT ENABLED! ");
            disableCallButton();
        }
    }

    public void callNumber(View view) {
        // Check for phone permission before making a call
        checkForPhonePermission();

        // Get the phone number from your UI, assuming you have an EditText with the ID phone_number_input
        EditText phoneNumberInput = findViewById(R.id.phone_number_input);
        String phoneNumber = phoneNumberInput.getText().toString();

        // Check if the phone number is not empty
        if (!TextUtils.isEmpty(phoneNumber)) {
            // Create an intent to make a phone call
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + phoneNumber));

            // If package resolves to an app, check for phone permission, and send intent
            if (callIntent.resolveActivity(getPackageManager()) != null) {
                checkForPhonePermission();
                startActivity(callIntent);
            } else {
                Log.e(TAG, "Can't resolve app for ACTION_CALL Intent");
            }
        } else {
            Toast.makeText(this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isTelephonyEnabled()) {
            mTelephonyManager.listen(mListener, PhoneStateListener.LISTEN_NONE);
        }
    }

    private boolean isTelephonyEnabled() {
        if (mTelephonyManager != null) {
            return mTelephonyManager.getSimState() == TelephonyManager.SIM_STATE_READY;
        }
        return false;
    }

    private void disableCallButton() {
        Toast.makeText(this, "Phone calling disabled", Toast.LENGTH_LONG).show();
        ImageButton callButton = findViewById(R.id.phone_icon);
        callButton.setVisibility(View.INVISIBLE);
        if (isTelephonyEnabled()) {
            Button retryButton = findViewById(R.id.button_retry);
            retryButton.setVisibility(View.VISIBLE);
        }
    }

    private void enableCallButton() {
        ImageButton callButton = findViewById(R.id.phone_icon);
        callButton.setVisibility(View.VISIBLE);
    }

    public void retryApp(View view) {
        enableCallButton();
        Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
        startActivity(intent);
    }

    private void checkForPhonePermission() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "PERMISSION NOT GRANTED!");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            enableCallButton();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.CALL_PHONE)
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted.
                } else {
                    Log.d(TAG, "Failure to obtain permission!");
                    Toast.makeText(this, "Failure to obtain permission!", Toast.LENGTH_LONG).show();
                    disableCallButton();
                }
            }
        }
    }

    private class MyPhoneCallListener extends PhoneStateListener {

        private boolean returningFromOffHook = false;

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            String message = getString(R.string.phone_status);
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    message = message + getString(R.string.ringing) + incomingNumber;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    Log.i(TAG, message);
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    message = message + getString(R.string.offhook);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    Log.i(TAG, message);
                    returningFromOffHook = true;
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    message = message + getString(R.string.idle);
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    Log.i(TAG, message);
                    if (returningFromOffHook) {
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                            Log.i(TAG, getString(R.string.restarting_app));
                            Intent intent = getPackageManager()
                                    .getLaunchIntentForPackage(getPackageName());
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                    }
                    break;
                default:
                    message = message + "Phone off";
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    Log.i(TAG, message);
                    break;
            }
        }
    }
}
