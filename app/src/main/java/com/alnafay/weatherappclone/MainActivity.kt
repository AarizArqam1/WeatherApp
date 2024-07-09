package com.alnafay.weatherappclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.alnafay.weatherappclone.ui.theme.WeatherAppCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[WeatherViewModel::class.java]
        setContent {
            WeatherAppCloneTheme {
                WeatherPage(viewModel)
            }
        }
    }
}


