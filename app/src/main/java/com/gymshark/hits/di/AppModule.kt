package com.gymshark.hits.di

import android.content.Context
import com.gymshark.hits.network.HitsAPI
import com.gymshark.hits.repository.HitsRepository
import com.gymshark.hits.utils.Constants.BASE_URL
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

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

interface AppModule {
    val provideHitsApi: HitsAPI
    val provideHitsRepository: HitsRepository

}

class AppModuleImpl(hitsApplication: Context) : AppModule {

    private val annotationInterceptor = AnnotationInterceptor()
    private val cacheSize = (5 * 1024 * 1024).toLong()

    private val client = OkHttpClient().newBuilder().apply {
        addInterceptor(annotationInterceptor)
    }.cache(Cache(hitsApplication.cacheDir, cacheSize))
        .build()

    override val provideHitsApi: HitsAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) //TODO findout why moshi is not working
            .client(client)
            .build()
            .create(HitsAPI::class.java)
    }
    override val provideHitsRepository: HitsRepository by lazy {
        HitsRepository(provideHitsApi)
    }

}