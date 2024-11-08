package com.gymshark.hits.repository

import com.gymshark.hits.data.DataOrException
import com.gymshark.hits.model.AllHits
import com.gymshark.hits.network.HitsAPI
import javax.inject.Inject

class HitsRepository (private val hitsService: HitsAPI) {
    suspend fun getHits(): DataOrException<AllHits, Boolean, Exception> {
        val response = try {
            hitsService.getProducts()
        } catch (e:Exception) {
            return DataOrException( e = e)
        }
        return DataOrException(data = response)
    }
}