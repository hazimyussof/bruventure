package com.lortnoc.bruventure.viewpager_fragments

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.lortnoc.bruventure.R
import kotlinx.android.synthetic.main.fragment_step.*
import java.text.DecimalFormat

class StepFragment: Fragment(R.layout.fragment_step), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var running = false
    private var totalSteps = 0f
    private var previousTotalSteps = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        resetSteps()
        sensorManager = activity!!.getSystemService(Context.SENSOR_SERVICE) as SensorManager

        val sensorButton: Button = view.findViewById(R.id.sensorButton)
        sensorButton.setOnClickListener {
            if (sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) != null) {
                Toast.makeText(context, "device supports Sensor", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(context, "this device does not support a sensor", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (stepSensor == null) {
            Toast.makeText(context, "this device does not support a sensor", Toast.LENGTH_SHORT).show()
        }
        else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_FASTEST)
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running) {
            totalSteps = event!!.values[0]
            val currentSteps = totalSteps.toInt() - previousTotalSteps.toInt()
            stepsTaken.text = ("$currentSteps")

            calorieCounter()
            distanceCounter()

            circularProgressBar.apply {
                setProgressWithAnimation(currentSteps.toFloat())
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) { /* NO NEED... */  }

    private fun resetSteps() {
        stepsTaken.setOnClickListener {
            Toast.makeText(context, "Long tap to reset steps", Toast.LENGTH_SHORT).show()
        }
        stepsTaken.setOnLongClickListener {
            previousTotalSteps = totalSteps
            stepsTaken.text = 0.toString()
            saveData()

            true
        }
    }

    private fun saveData() {
        val sharedPreferences = this.activity!!.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putFloat("key1", previousTotalSteps)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = this.activity!!.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
        val savedNumber: Float = sharedPreferences.getFloat("key1", 0f)
        Log.d("MainActivity", "$savedNumber")
        previousTotalSteps = savedNumber
    }

    private fun calorieCounter() {
        val getSteps = stepsTaken.text.toString()
        // Formula for CalorieCounter = An average person looses 40calories per 1000 steps (1 calorie per 25 steps).
        val totalCalories: Int = getSteps.toInt() / 25
        calorie_count.text = ("$totalCalories")
    }

    private fun distanceCounter() {
        val getSteps = stepsTaken.text.toString()
        // Formula for DistanceCounter = An average person takes 1350 steps to walk 1KM (1 step to walk 0.00074074074074074 KM).
        val totalDistance: Float = getSteps.toInt() * 0.00074074074074074F
        val decimalFormat = DecimalFormat("#.#")
        val formattedDistance = decimalFormat.format(totalDistance.toDouble())
        distance_count.text = (formattedDistance)
    }
}

/* Pedometer Code adapted from https://www.youtube.com/watch?v=WSx2a99kPY4&t=1s*/