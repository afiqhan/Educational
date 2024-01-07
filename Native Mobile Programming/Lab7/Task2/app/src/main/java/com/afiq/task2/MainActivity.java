package com.afiq.task2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor proximitySensor;
    private Sensor humiditySensor;

    private TextView lightLevelTextView;
    private TextView proximityTextView;
    private TextView humidityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map the TextViews to the layout resources
        lightLevelTextView = findViewById(R.id.lightTextView);
        proximityTextView = findViewById(R.id.proximityTextView);
        humidityTextView = findViewById(R.id.humidityTextView);

        // Get the SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Get the default sensors
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        // Check if sensors are available
        if (lightSensor != null) {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this, "Light sensor found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Light sensor not found", Toast.LENGTH_SHORT).show();
        }

        if (proximitySensor != null) {
            sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this, "Proximity sensor found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Proximity sensor not found", Toast.LENGTH_SHORT).show();
        }

        if (humiditySensor != null) {
            sensorManager.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
            Toast.makeText(this, "Humidity sensor found", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Humidity sensor not found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        // Update the TextView with the current sensor values
        switch (event.sensor.getType()) {
            case Sensor.TYPE_LIGHT:
                lightLevelTextView.setText(String.format("Light Level: %.2f", event.values[0]));
                break;
            case Sensor.TYPE_PROXIMITY:
                proximityTextView.setText(String.format("Proximity: %.2f", event.values[0]));
                break;
            case Sensor.TYPE_RELATIVE_HUMIDITY:
                humidityTextView.setText(String.format("Humidity: %.2f", event.values[0]));
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
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listeners when the activity is paused
        sensorManager.unregisterListener(this);
    }
}
