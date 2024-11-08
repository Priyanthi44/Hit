package com.gymshark.hits.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

import kotlin.reflect.KClass

class ViewModelFactoryHelper {
    fun <VM:ViewModel> viewModelFactory(v:()-> VM): ViewModelProvider.Factory  {
        return object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
                @Suppress("UNCHECKED_CAST")
                return v() as T
            }
        }
    }
}