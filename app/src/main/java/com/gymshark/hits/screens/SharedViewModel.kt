package com.gymshark.hits.screens

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gymshark.hits.data.DataOrException
import com.gymshark.hits.model.AllHits
import com.gymshark.hits.repository.HitsRepository
import kotlinx.coroutines.launch

//@HiltViewModel
class SharedViewModel (
    private val repository: HitsRepository

) : ViewModel() {

    val data: MutableState<DataOrException<AllHits, Boolean, Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getAllHits()
    }

    private fun getAllHits() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getHits()
            if (data.value.data.toString().isNotEmpty()) data.value.loading = false
        }
        Log.d ("DATA",data.value.data.toString())
    }


}
