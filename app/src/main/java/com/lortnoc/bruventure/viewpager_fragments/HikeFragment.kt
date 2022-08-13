package com.lortnoc.bruventure.viewpager_fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.lortnoc.bruventure.MainActivity
import com.lortnoc.bruventure.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import org.json.JSONObject
import java.text.DateFormat
import java.util.*

class HikeFragment: Fragment(R.layout.fragment_hike) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = "https://api.openweathermap.org/data/2.5/weather?id=1820906&appid=6b6fe71661cb0c853d8f83fdb1d3004c&units=metric"

        val city: TextView = view.findViewById(R.id.city)
        val date: TextView = view.findViewById(R.id.date)
        val weather: TextView = view.findViewById(R.id.weather)
        val temp: TextView = view.findViewById(R.id.number)
        val c: TextView = view.findViewById(R.id.c)
        val weatherStatus: TextView = view.findViewById(R.id.weather_status)

        val refreshButton: Button = view.findViewById(R.id.refresh_button)

        refreshButton.setOnClickListener {

            val req: RequestQueue = Volley.newRequestQueue(context)
            val que = JsonObjectRequest(Request.Method.GET, url, null, { response ->

                Toast.makeText(context, "Weather updated", Toast.LENGTH_SHORT).show()

                val mainObject: JSONObject = response.getJSONObject("main")
                val array: JSONArray = response.getJSONArray("weather")
                val jsonObject: JSONObject = array.getJSONObject(0)

                // Json Getter and Setter for City TextView
                val getCity: String = response.getString("name")
                city.text = getCity

                // Json Getter and Setter for Weather TextView
                val getWeather: String = jsonObject.getString("description")
                weather.text = getWeather

                // Json Getter and Setter for Temp (Celsius) TextView
                val getTemp: String = ((mainObject.getDouble("temp")).toString())
                temp.text = getTemp

                // Formats and sets current date for Date TextView
                val dateFormat = DateFormat.getDateInstance().format(Date())
                val currentDate: String = dateFormat.format(Date().toString())
                date.text = currentDate

                c.text = "C"
                weatherStatus.text = ""

            }, {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
            })
            req.add(que)
        }

        val stepButton: Button = view.findViewById(R.id.step_counter_button)
        stepButton.setOnClickListener {
            (activity as MainActivity?)?.viewPager?.currentItem = (activity as MainActivity?)?.viewPager?.currentItem?.plus(2)!!
        }
    }
}


