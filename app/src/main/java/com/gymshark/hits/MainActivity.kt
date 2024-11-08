package com.gymshark.hits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.lifecycle.viewmodel.compose.viewModel

import com.gymshark.hits.navigation.HitsNavigaton
import com.gymshark.hits.screens.home.MainScreenViewModel

import com.gymshark.hits.ui.theme.HitsTheme
import com.gymshark.hits.utils.ViewModelFactoryHelper


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            HitsTheme {
                val viewModel = viewModel<MainScreenViewModel>(
                    factory = ViewModelFactoryHelper(). viewModelFactory {
                        MainScreenViewModel(HitsApplication.instance.provideHitsRepository)
                    })
                HitsNavigaton(viewModel)
            }
        }
    }





}