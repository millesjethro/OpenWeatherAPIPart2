package com.example.openweatherapi

import android.R
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.openweatherapi.adapters.AdapterWeather
import com.example.openweatherapi.constants.API_KEY
import com.example.openweatherapi.databinding.ActivityMainBinding
import com.example.openweatherapi.models.Coord
import com.example.openweatherapi.models.ForecastModel
import com.example.openweatherapi.models.MainForecastModel
import com.example.openweatherapi.services.helpers.RetrofitHelper
import com.example.openweatherapi.services.repository.OpenWeatherAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener{
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterWeather
    private lateinit var forecastData: ArrayList<ForecastModel>
    private lateinit var mainForecast: ArrayList<MainForecastModel>
    private lateinit var Location: ArrayList<Coord>
    private lateinit var nextWeather: ForecastModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        LoadingScreen()
        forecastData = arrayListOf()

        adapter = AdapterWeather(forecastData, this)

        Location = arrayListOf(
            Coord("Concepcion",15.3388712, 120.5268719),
            Coord("Quezon City", 14.6838776,120.8973811),
            Coord("Manila",14.5964838,120.8971588)
        )

        val city = arrayOf("Concepcion", "Quezon City", "Manila")

        val spinnerAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, city)
        binding.spinner.adapter = spinnerAdapter
        binding.spinner.onItemSelectedListener = this

        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.rvForecast.layoutManager = layoutManager
        binding.rvForecast.adapter = adapter
        binding.btnhome.isVisible = false
        binding.btnsearch.isVisible = false
        binding.btnmenulist.setOnClickListener{
            val animationFadeOut = AnimationUtils.loadAnimation(this, com.example.openweatherapi.R.anim.fade_out)
            val animationFadeIn = AnimationUtils.loadAnimation(this, com.example.openweatherapi.R.anim.fade_in)
            if(binding.btnhome.isVisible == false){
                binding.btnhome.isVisible = true
                binding.btnsearch.isVisible = true
                binding.btnhome.startAnimation(animationFadeIn)
                binding.btnsearch.startAnimation(animationFadeIn)
            }
            else{
                binding.btnhome.isVisible = false
                binding.btnsearch.isVisible = false
                binding.btnhome.startAnimation(animationFadeOut)
                binding.btnsearch.startAnimation(animationFadeOut)
            }

        }
        binding.btnhome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.btnsearch.setOnClickListener{
            val intent = Intent(this, SearchWeather::class.java)
            startActivity(intent)
        }
    }


    private fun WeatherData(lat: Double, lon : Double) {
        super.onResume()

        val WeatherAPI = RetrofitHelper.getInstance().create(OpenWeatherAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val result = WeatherAPI.getFiveDayForecast(lat,lon, API_KEY, "metric")
            val weatherData = result.body()

            if(weatherData != null){
                nextWeather = weatherData.list[0]
                forecastData.clear()
                forecastData.addAll(weatherData.list)
                withContext(Dispatchers.Main){
                    adapter.UpdateWeather(forecastData)
                }
            }

            binding.weatherDateNext.text = getDay(nextWeather.dt.toLong())
            binding.maxTempNext.text = String.format("%s C°",nextWeather.main.temp_max)
            binding.minTempNext.text = String.format("%s C°",nextWeather.main.temp_min)
            binding.tempNext.text = String.format("%s C°",nextWeather.main.temp)

            when ("ic_"+ nextWeather.weather[0].icon) {
                "ic_01d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_01d)
                "ic_02d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_02d)
                "ic_03d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_03d)
                "ic_04d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_04d)
                "ic_09d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_09d)
                "ic_10d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_10d)
                "ic_11d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_11d)
                "ic_13d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_13d)
                "ic_50d" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_50d)
                "ic_01n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_01n)
                "ic_02n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_02n)
                "ic_03n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_03n)
                "ic_04n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_04n)
                "ic_09n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_09n)
                "ic_10n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_10n)
                "ic_11n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_11n)
                "ic_13n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_13n)
                "ic_50n" -> binding.weatherNext.setImageResource(com.example.openweatherapi.R.drawable.ic_50n)
            }
        }

    }


    private fun getDay(timeStamp: Long): String{
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timeStamp * 1000)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val locationData = Location[p2]
        WeatherData(locationData.lat,locationData.lon)
        LoadingScreen()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    private fun LoadingScreen(){
        binding.imgloading.isVisible = true
        binding.btnmenulist.isVisible = false
        object : CountDownTimer(3000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                binding.imgloading.isVisible = false
                binding.btnmenulist.isVisible = true
            }
        }.start()
    }


}