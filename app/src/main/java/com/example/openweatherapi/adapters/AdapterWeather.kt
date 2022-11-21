package com.example.openweatherapi.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.openweatherapi.MainActivity
import com.example.openweatherapi.MoreWeatherInfo
import com.example.openweatherapi.R
import com.example.openweatherapi.databinding.ContentForecastRvBinding
import com.example.openweatherapi.models.ForecastModel
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AdapterWeather(private var forecastList: ArrayList<ForecastModel>, private var context: Context) : RecyclerView.Adapter<AdapterWeather.WeatherForcastViewHolder>(),Serializable {
    inner class WeatherForcastViewHolder(private val binding: ContentForecastRvBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(itemData: ForecastModel){

            val mainWeatherData = itemData.weather[0]
            val weatherIcon = "ic_"+mainWeatherData.icon
            binding.txtWeatherType.text = mainWeatherData.main
            binding.txtTemp.text = String.format("%s C°",itemData.main.temp)
            binding.txttime.text = getTime(itemData.dt.toLong())
            binding.txtDay.text = getDay(itemData.dt.toLong())
            when(weatherIcon){
                "ic_01d" -> binding.imgWeather.setImageResource(R.drawable.ic_01d)
                "ic_02d" -> binding.imgWeather.setImageResource(R.drawable.ic_02d)
                "ic_03d" -> binding.imgWeather.setImageResource(R.drawable.ic_03d)
                "ic_04d" -> binding.imgWeather.setImageResource(R.drawable.ic_04d)
                "ic_09d" -> binding.imgWeather.setImageResource(R.drawable.ic_09d)
                "ic_10d" -> binding.imgWeather.setImageResource(R.drawable.ic_10d)
                "ic_11d" -> binding.imgWeather.setImageResource(R.drawable.ic_11d)
                "ic_13d" -> binding.imgWeather.setImageResource(R.drawable.ic_13d)
                "ic_50d" -> binding.imgWeather.setImageResource(R.drawable.ic_50d)
                "ic_01n" -> binding.imgWeather.setImageResource(R.drawable.ic_01n)
                "ic_02n" -> binding.imgWeather.setImageResource(R.drawable.ic_02n)
                "ic_03n" -> binding.imgWeather.setImageResource(R.drawable.ic_03n)
                "ic_04n" -> binding.imgWeather.setImageResource(R.drawable.ic_04n)
                "ic_09n" -> binding.imgWeather.setImageResource(R.drawable.ic_09n)
                "ic_10n" -> binding.imgWeather.setImageResource(R.drawable.ic_10n)
                "ic_11n" -> binding.imgWeather.setImageResource(R.drawable.ic_11n)
                "ic_13n" -> binding.imgWeather.setImageResource(R.drawable.ic_13n)
                "ic_50n" -> binding.imgWeather.setImageResource(R.drawable.ic_50n)
            }


            binding.weatherForecast.setOnClickListener {
                var intent = Intent(context, MoreWeatherInfo::class.java)
                intent.putExtra("itemData",itemData)
                context.startActivity(intent)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherForcastViewHolder {
        val binding = ContentForecastRvBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WeatherForcastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherForcastViewHolder, position: Int) {
        val forcastData = forecastList[position]
        holder.bind(forcastData)
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    private fun getDay(timeStamp: Long): String{
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(timeStamp * 1000)
    }

    private fun getTime(timeStamp: Long): String{
        return  SimpleDateFormat("hh:mm 00", Locale.ENGLISH).format(timeStamp*1000)
    }

    fun UpdateWeather(forecastList: ArrayList<ForecastModel>){
        this.forecastList = arrayListOf()
        notifyDataSetChanged()
        this.forecastList = forecastList
        this.notifyItemInserted(this.forecastList.size)
    }


}