package com.example.openweatherapi

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.openweatherapi.databinding.ActivityMoreWeatherInfoBinding
import com.example.openweatherapi.models.ForecastModel


class MoreWeatherInfo : AppCompatActivity(), View.OnClickListener {
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

        binding.imgweatherinfo.isVisible = false
        binding.weatherinfoname.isVisible = false
        binding.weatherinfopic.isVisible = false
        binding.weatherval.isVisible = false
        binding.btnClos.isVisible = false
        binding.bgblur.isVisible = false

        binding.imgdirection.setOnClickListener(this)
        binding.imggroundlevel.setOnClickListener(this)
        binding.imggust.setOnClickListener(this)
        binding.imgpressure.setOnClickListener(this)
        binding.imgsealevel.setOnClickListener(this)
        binding.imghumidity.setOnClickListener(this)
        binding.imgspeed.setOnClickListener(this)
        binding.imgtemp.setOnClickListener(this)
        binding.btnClos.setOnClickListener(this)
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

    override fun onClick(p0: View?) {
        val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)

        val intent = intent
        val itemData: ForecastModel? = intent.getSerializableExtra("itemData") as ForecastModel?

        when(p0!!.id){
            (R.id.btnClos)->{
                binding.imgweatherinfo.isVisible = false
                binding.weatherinfoname.isVisible = false
                binding.weatherinfopic.isVisible = false
                binding.weatherval.isVisible = false
                binding.btnClos.isVisible = false
                binding.bgblur.isVisible = false
            }
            (R.id.imgtemp)->{
                binding.imgtemp.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imgtemp.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.thermometer)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "TEMPERATURE:"
                        binding.weatherval.text = itemData?.main?.temp.toString()+" C°"
                    }
                }.start()
            }
            (R.id.imggust)->{
                binding.imggust.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imggust.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.windgust)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "GUST:"

                        binding.weatherval.text = itemData?.wind?.gust.toString()+" m/s"

                    }
                }.start()
            }
            (R.id.imgdirection)->{
                binding.imgdirection.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imgdirection.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.compassmagnetism)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "DIRECTION:"
                        if(itemData?.wind?.deg!! == 0 ){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" N"
                        }
                        else if(itemData?.wind?.deg!! >= 1 && itemData?.wind?.deg!! <= 89){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" NE"
                        }
                        else if(itemData?.wind?.deg!! == 90){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" E"
                        }
                        else if(itemData?.wind?.deg!! >= 91 && itemData?.wind?.deg!! <= 179){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" SE"
                        }
                        else if(itemData?.wind?.deg!! == 180){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" S"
                        }
                        else if(itemData?.wind?.deg!! >= 181 && itemData?.wind?.deg!! <= 269){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" SW"
                        }
                        else if(itemData?.wind?.deg!! == 270){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" W"
                        }
                        else if(itemData?.wind?.deg!! == 271 && itemData?.wind?.deg!! <= 359){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" NW"
                        }
                        else if(itemData?.wind?.deg!! == 360){
                            binding.weatherval.text = itemData?.wind?.deg.toString()+"°"+" N"
                        }

                    }
                }.start()
            }
            (R.id.imgspeed)->{
                binding.imgspeed.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imgspeed.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.speedometer)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "SPEED:"
                        binding.weatherval.text = itemData?.wind?.speed.toString()+" m/s"

                    }
                }.start()
            }
            (R.id.imghumidity)->{
                binding.imghumidity.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imghumidity.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.humidity)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "HUMIDITY:"
                        binding.weatherval.text = itemData?.main?.humidity.toString()+" %"

                    }
                }.start()
            }
            (R.id.imgpressure)->{
                binding.imgpressure.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imgpressure.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.pressure)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "PRESSURE:"
                        binding.weatherval.text = itemData?.main?.pressure.toString()+" hPa"

                    }
                }.start()
            }
            (R.id.imgsealevel)->{
                binding.imgsealevel.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imgsealevel.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.sea)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "SEA LEVEL PRESSURE:"
                        binding.weatherval.text = itemData?.main?.sea_level.toString()+" hPa"

                    }
                }.start()
            }
            (R.id.imggroundlevel)->{
                binding.imggroundlevel.startAnimation(animationZoomIn)
                object : CountDownTimer(500, 100) {
                    override fun onTick(millisUntilFinished: Long) {

                    }

                    override fun onFinish() {
                        binding.imggroundlevel.startAnimation(animationZoomOut)
                        openWeatherinfo()
                        binding.weatherinfopic.setAnimation(R.raw.background)
                        binding.weatherinfopic.playAnimation()
                        binding.weatherinfoname.text = "GROUND LEVEL PRESSURE:"
                        binding.weatherval.text = itemData?.main?.grnd_level.toString()+" hPa"
                    }
                }.start()
            }
        }
    }
    private fun openWeatherinfo(){
        binding.imgweatherinfo.isVisible = true
        binding.weatherinfoname.isVisible = true
        binding.weatherinfopic.isVisible = true
        binding.weatherval.isVisible = true
        binding.btnClos.isVisible = true
        binding.bgblur.isVisible = true
    }
}