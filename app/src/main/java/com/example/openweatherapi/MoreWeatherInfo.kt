package com.example.openweatherapi

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.openweatherapi.databinding.ActivityMoreWeatherInfoBinding
import com.example.openweatherapi.models.ForecastModel


class MoreWeatherInfo : AppCompatActivity() {
    private lateinit var binding: ActivityMoreWeatherInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoreWeatherInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        LoadingScreen()
        supportActionBar?.hide()

        val intent = intent
        val itemData: ForecastModel? = intent.getSerializableExtra("itemData") as ForecastModel?

        val weatherIcon = "ic_"+itemData?.weather?.get(0)?.icon
        when (weatherIcon) {
            "ic_01d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_01d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_02d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_02d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_03d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_03d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_04d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_04d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_09d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_09d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_10d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_10d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_11d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_11d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_13d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_13d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_50d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_50d","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_01n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_01n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_02n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_02n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_03n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_03n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_04n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_04n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_09n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_09n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_10n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_10n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_11n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_11n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_13n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_13n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
            "ic_50n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_50n","drawable",this.packageName))
                .into(binding.imgWeatherCloud)
        }
        when (weatherIcon) {
            "ic_01d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_02d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_03d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_04d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_09d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_10d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_11d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_13d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_50d" -> Glide.with(this)
                .load(resources.getIdentifier("ic_kyoto","drawable",this.packageName))
                .into(binding.imageView)
            "ic_01n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_02n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_03n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_04n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_09n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_10n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_11n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_13n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
            "ic_50n" -> Glide.with(this)
                .load(resources.getIdentifier("ic_calm_darya","drawable",this.packageName))
                .into(binding.imageView)
        }

        binding.infocloud.text = itemData?.weather?.get(0)?.description
        binding.infodirection.text = itemData?.wind?.deg.toString()+"°"
        binding.infogust.text = itemData?.wind?.gust.toString()+" m/s"
        binding.infospeed.text = itemData?.wind?.speed.toString()+" m/s"
        binding.infotemp.text = itemData?.main?.temp.toString()+" C°"
        binding.infohumidity.text = itemData?.main?.humidity.toString()+"%"
        binding.infopressure.text = itemData?.main?.pressure.toString()+" hPa"
        binding.infosealevel.text = itemData?.main?.sea_level.toString()+" hPa"
        binding.infogroundlevel.text = itemData?.main?.grnd_level.toString()+" hPa"

    }

    private fun LoadingScreen(){
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                binding.imgloading.isVisible = false
            }
        }.start()
    }
}