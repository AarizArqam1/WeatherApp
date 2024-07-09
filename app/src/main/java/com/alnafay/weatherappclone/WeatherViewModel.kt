package com.alnafay.weatherappclone

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alnafay.weatherappclone.api.Constants.apiKey
import com.alnafay.weatherappclone.api.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel :ViewModel() {

    private val weatherapi=RetrofitInstance.weatherApi
    fun getData(city:String){
        viewModelScope.launch {
            val response = weatherapi.getWeather(apiKey = apiKey,city)
            response
            if(response.isSuccessful){
                Log.i("Response",response.body().toString())
            }else{
                Log.i("Error",response.message().toString())
            }
        }

    }
}