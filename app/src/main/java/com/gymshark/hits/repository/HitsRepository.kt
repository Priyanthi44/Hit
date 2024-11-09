package com.gymshark.hits.repository

import android.util.Log
import com.gymshark.hits.data.DataOrException
import com.gymshark.hits.model.AllHits
import com.gymshark.hits.network.HitsAPI
import javax.inject.Inject

class HitsRepository (private val hitsService: HitsAPI) {
    suspend fun getHits(): DataOrException<AllHits, Boolean, Exception> {
        val response = try {
            hitsService.getProducts()

        } catch (e:Exception) {
            Log.d("DATA", e.toString())
            return DataOrException( e = e)
        }
        Log.d("DATA", response.toString())
        return DataOrException(data = response)
    }
}