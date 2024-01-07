package com.afiq.task2.tasks;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.afiq.task2.R;

public class Task1 extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private TextView lightLevelTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map the TextView to the layout resource
        lightLevelTextView = findViewById(R.id.lightTextView);

        // Get the SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Get the default light sensor
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        // Check if the light sensor is available
        if (lightSensor != null) {
            // Register the listener for the light sensor
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this, "Light sensor found", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Light sensor not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Update the TextView with the current light level
        lightLevelTextView.setText(String.format("Light Level: %.2f", event.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for light sensor
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the listener when the activity is resumed
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener when the activity is paused
        sensorManager.unregisterListener(this);
    }

}
