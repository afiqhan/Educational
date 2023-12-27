package com.alomory.task3;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class PositionSensorsActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;
    private Sensor gyroscopeSensor;
    private Sensor magnetometerSensor;

    private TextView accelerometerTextView;
    private TextView gyroscopeTextView;
    private TextView magnetometerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position_sensors);

        // Map the TextViews to the layout resources
        accelerometerTextView = findViewById(R.id.accelerometerTextView);
        gyroscopeTextView = findViewById(R.id.gyroscopeTextView);
        magnetometerTextView = findViewById(R.id.magnetometerTextView);

        // Get the SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Get the default sensors
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        magnetometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        // Check if sensors are available
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if (gyroscopeSensor != null) {
            sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        if (magnetometerSensor != null) {
            sensorManager.registerListener(this, magnetometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Update the TextViews with the current sensor values
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER:
                accelerometerTextView.setText(String.format("Accelerometer\nX: %.2f\nY: %.2f\nZ: %.2f",
                        event.values[0], event.values[1], event.values[2]));
                break;
            case Sensor.TYPE_GYROSCOPE:
                gyroscopeTextView.setText(String.format("Gyroscope\nX: %.2f\nY: %.2f\nZ: %.2f",
                        event.values[0], event.values[1], event.values[2]));
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                magnetometerTextView.setText(String.format("Magnetometer\nX: %.2f\nY: %.2f\nZ: %.2f",
                        event.values[0], event.values[1], event.values[2]));
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not needed for this example
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Register the listeners when the activity is resumed
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listeners when the activity is paused
        sensorManager.unregisterListener(this);
    }
}
