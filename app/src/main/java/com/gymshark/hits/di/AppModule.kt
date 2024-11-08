package com.gymshark.hits.di

import android.content.Context
import com.gymshark.hits.network.HitsAPI
import com.gymshark.hits.repository.HitsRepository
import com.gymshark.hits.utils.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.Contexts
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule{
//    // Create a Moshi instance
//    private val moshi: Moshi = Moshi.Builder().build()
//    @Provides
//    @Singleton
//    fun provideHitsApi(): HitsAPI {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//            .create(HitsAPI::class.java)
//    }
//}

interface AppModule{
    val provideHitsApi:HitsAPI
val provideHitsRepository: HitsRepository

}

class AppModuleImpl(private val appContext: Context):AppModule{
    override val provideHitsApi: HitsAPI by lazy {
        val moshi = Moshi.Builder() // adapter
            .add(KotlinJsonAdapterFactory())
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(HitsAPI::class.java)
    }
    override val provideHitsRepository: HitsRepository by lazy {
        HitsRepository(provideHitsApi)
    }

}