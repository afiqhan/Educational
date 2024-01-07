package com.afiq.lab7.task1

import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.afiq.lab7.R
import java.util.Arrays

class MainActivity : AppCompatActivity() {
    var senseMan: SensorManager? = null
    var lv: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lv = findViewById<View>(R.id.listview) as ListView
        senseMan = getSystemService(SENSOR_SERVICE) as SensorManager
        val sensorList = senseMan!!.getSensorList(Sensor.TYPE_ALL)
        lv!!.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, sensorList)
        println(Arrays.asList(sensorList))
    }
}