package com.gymshark.hits

import android.app.Application
import com.gymshark.hits.di.AppModule
import com.gymshark.hits.di.AppModuleImpl
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class HitsApplication: Application() {
    companion object {
        lateinit var instance: AppModule

    }

    override fun onCreate() {
        super.onCreate()
        instance = AppModuleImpl(this)
    }
}