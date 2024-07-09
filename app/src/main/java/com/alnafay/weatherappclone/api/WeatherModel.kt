package com.alnafay.weatherappclone.api

import com.google.gson.annotations.SerializedName


data class WeatherModel (

    @SerializedName("location" ) var location : Location? = Location(),
    @SerializedName("current"  ) var current  : Current?  = Current()

)