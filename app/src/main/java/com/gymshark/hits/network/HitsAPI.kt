package com.gymshark.hits.network

import com.gymshark.hits.model.AllHits
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface HitsAPI {
    @GET("training/mock-product-responses/algolia-example-payload.json")
    suspend fun getProducts(): AllHits

}