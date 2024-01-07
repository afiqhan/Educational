package com.afiq.lab7.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.afiq.lab7.R;

import java.util.Arrays;
import java.util.List;

public class Task1 extends AppCompatActivity {


    SensorManager senseMan;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.listview);

        senseMan = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensorList = senseMan.getSensorList(Sensor.TYPE_ALL);

        lv.setAdapter(new ArrayAdapter<Sensor>(this, android.R.layout.simple_list_item_1, sensorList));
        System.out.println(Arrays.asList(sensorList));
    }
}