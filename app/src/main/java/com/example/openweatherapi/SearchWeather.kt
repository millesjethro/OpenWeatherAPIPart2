package com.example.openweatherapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.openweatherapi.constants.API_KEY
import com.example.openweatherapi.databinding.ActivitySearchWeatherBinding
import com.example.openweatherapi.services.helpers.RetrofitHelper
import com.example.openweatherapi.services.repository.CurrentWeatherAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class SearchWeather : AppCompatActivity(),View.OnClickListener {
private lateinit var binding: ActivitySearchWeatherBinding

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivitySearchWeatherBinding.inflate(layoutInflater)
    setContentView(binding.root)
    supportActionBar?.hide()
    binding.makemevisible.isVisible = false
    binding.btnhomeSW.isVisible = false
    binding.btnsearchSW.isVisible = false
    binding.searchplacr.setOnClickListener(this)
    binding.btnmenulistSW.setOnClickListener(this)
    binding.btnsearchSW.setOnClickListener(this)
    binding.btnhomeSW.setOnClickListener(this)

}

override fun onClick(p0: View?) {
    val animationFadeOut = AnimationUtils.loadAnimation(this, com.example.openweatherapi.R.anim.fade_out)
    val animationFadeIn = AnimationUtils.loadAnimation(this, com.example.openweatherapi.R.anim.fade_in)
    when(p0!!.id){
        (R.id.btnmenulistSW)->{
            if(binding.btnhomeSW.isVisible == true){
                binding.btnhomeSW.isVisible = false
                binding.btnsearchSW.isVisible = false
                binding.btnhomeSW.startAnimation(animationFadeOut)
                binding.btnsearchSW.startAnimation(animationFadeOut)

            }
            else{
                binding.btnhomeSW.isVisible = true
                binding.btnsearchSW.isVisible = true
                binding.btnhomeSW.startAnimation(animationFadeIn)
                binding.btnsearchSW.startAnimation(animationFadeIn)
            }
        }
        (R.id.searchplacr)->{

            if(binding.placeSearch.text.isEmpty()){
                binding.searchplacr.error = "Required"
            }
            else{
                binding.makemevisible.isVisible = true
                CurrentWeatherData(binding.placeSearch.text.toString())
            }
        }
        (R.id.btnhomeSW)->{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        (R.id.btnsearchSW)->{
            val intent = Intent(this, SearchWeather::class.java)
            startActivity(intent)
        }

    }

}
private fun CurrentWeatherData(q: String) {
    super.onResume()
    val currentAPI = RetrofitHelper.getInstance().create(CurrentWeatherAPI::class.java)

    GlobalScope.launch(Dispatchers.IO) {
        val result = currentAPI.getTodaysWeather(q, API_KEY)
        val todayWeatherData = result.body()

        if (todayWeatherData != null) {
            withContext(Dispatchers.Main){
                binding.gustspeedvalue.text = todayWeatherData.wind.gust.toString()+" m/s"
                binding.windspeedvalue.text = todayWeatherData.wind.speed.toString()+" m/s"
                binding.tempvalue.text = todayWeatherData.main.temp.toString()+" C°"
                binding.maxtempvalue.text = todayWeatherData.main.temp_max.toString()+" C°"
                binding.mintempvalue.text = todayWeatherData.main.temp_min.toString()+" C°"
                binding.humidityvalue.text = todayWeatherData.main.humidity.toString()+" %"
                binding.pressurevalue.text = todayWeatherData.main.pressure.toString()+" hPa"
                binding.grdpressvalue.text = todayWeatherData.main.grnd_level.toString()+" hPa"
                binding.seapressvalue.text = todayWeatherData.main.sea_level.toString()+" hPa"
                binding.CloudValue.text = todayWeatherData.weather[0].description
                if(todayWeatherData?.wind?.deg!! == 0 ){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" N"
                }
                else if(todayWeatherData?.wind?.deg!! in 1..89){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" NE"
                }
                else if(todayWeatherData?.wind?.deg!! == 90){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" E"
                }
                else if(todayWeatherData?.wind?.deg!! in 91..179){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" SE"
                }
                else if(todayWeatherData?.wind?.deg!! == 180){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" S"
                }
                else if(todayWeatherData?.wind?.deg!! in 181..269){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" SW"
                }
                else if(todayWeatherData?.wind?.deg!! == 270){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" W"
                }
                else if(todayWeatherData?.wind?.deg!! in 271..359){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" NW"
                }
                else if(todayWeatherData?.wind?.deg!! == 360){
                    binding.winddirectionvalue.text = todayWeatherData?.wind?.deg.toString()+"°"+" N"
                }

                when ("ic_"+ todayWeatherData.weather[0].icon) {
                    "ic_01d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_01d)
                    "ic_02d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_02d)
                    "ic_03d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_03d)
                    "ic_04d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_04d)
                    "ic_09d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_09d)
                    "ic_10d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_10d)
                    "ic_11d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_11d)
                    "ic_13d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_13d)
                    "ic_50d" -> binding.cloudsvalue.setImageResource(R.drawable.ic_50d)
                    "ic_01n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_01n)
                    "ic_02n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_02n)
                    "ic_03n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_03n)
                    "ic_04n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_04n)
                    "ic_09n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_09n)
                    "ic_10n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_10n)
                    "ic_11n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_11n)
                    "ic_13n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_13n)
                    "ic_50n" -> binding.cloudsvalue.setImageResource(R.drawable.ic_50n)
                }

            }

            }
        }
    }
}

