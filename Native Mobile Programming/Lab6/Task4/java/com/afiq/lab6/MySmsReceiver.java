/**
Author : Afiq Hanif (S62993)
*/

package com.afiq.lab6;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySmsReceiver extends BroadcastReceiver {
    private static final String TAG = MySmsReceiver.class.getSimpleName();
    public static final String PDU_TYPE = "pdus";
    public static final String FORMAT = "format";

    /**
     * Called when the BroadcastReceiver is receiving an Intent broadcast.
     *
     * @param context The Context in which the receiver is running.
     * @param intent  The Intent received.
     */
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onReceive(Context context, Intent intent) {
        // Get the SMS message.
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs;
        String strMessage = "";

        if (bundle != null) {
            // Retrieve the SMS message received.
            Object[] pdus = (Object[]) bundle.get(PDU_TYPE);
            String format = bundle.getString(FORMAT);

            if (pdus != null) {
                // Check the Android version.
                boolean isVersionM = (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M);
                // Fill the msgs array.
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < msgs.length; i++) {
                    // Check Android version and use appropriate createFromPdu.
                    try {
                        if (isVersionM) {
                            // If Android version M or newer:
                            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                        } else {
                            // If Android version L or older:
                            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Error creating SMS message from PDU", e);
                    }

                    if (msgs[i] != null) {
                        // Build the message to show.
                        strMessage += "SMS from " + msgs[i].getOriginatingAddress();
                        strMessage += " :" + msgs[i].getMessageBody() + "\n";
                        // Log and display the SMS message.
                        Log.i(TAG, "onReceive: " + strMessage);
                        Toast.makeText(context, strMessage, Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
