package com.afiq.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    SensorManager senseMan;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listview);

        senseMan = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensorList = senseMan.getSensorList(Sensor.TYPE_ALL);

        // Extract sensor names from the list
        String[] sensorNames = new String[sensorList.size()];
        for (int i = 0; i < sensorList.size(); i++) {
            sensorNames[i] = sensorList.get(i).getName();
        }

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorNames));
        System.out.println(Arrays.asList(sensorList));
    }
}
