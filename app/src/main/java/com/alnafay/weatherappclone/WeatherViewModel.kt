package com.alnafay.weatherappclone

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alnafay.weatherappclone.api.Constants.apiKey
import com.alnafay.weatherappclone.api.NetworkResponse
import com.alnafay.weatherappclone.api.RetrofitInstance
import com.alnafay.weatherappclone.api.WeatherModel
import kotlinx.coroutines.launch

class WeatherViewModel :ViewModel() {

    private val weatherapi=RetrofitInstance.weatherApi
    private val _weatherResult=MutableLiveData<NetworkResponse<WeatherModel>>()
    val weatherResult:LiveData<NetworkResponse<WeatherModel>> = _weatherResult
    fun getData(city:String){
        _weatherResult.value=NetworkResponse.Loading
        viewModelScope.launch {
            try{
                val response = weatherapi.getWeather(apiKey = apiKey,city)
                if(response.isSuccessful){
                    response.body()?.let{
                        _weatherResult.value=NetworkResponse.Success(it)
                    }
                }else{
                    _weatherResult.value=NetworkResponse.Error("Failed while api call")
                }
            }catch (e:Exception){
                _weatherResult.value=NetworkResponse.Error("Failed while api call")
            }

        }

    }
}