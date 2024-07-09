package com.alnafay.weatherappclone.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {


    private val baseURL="https://api.weatherapi.com";
    private fun getInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    val weatherApi:WeatherApi= getInstance().create(WeatherApi::class.java)

}