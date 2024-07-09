package com.alnafay.weatherappclone.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("Key") apiKey:String,
        @Query("q") Q:String
    ): Response<WeatherModel>
}