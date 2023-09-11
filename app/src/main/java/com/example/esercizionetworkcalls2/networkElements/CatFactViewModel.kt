package com.example.esercizionetworkcalls2.networkElements

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class CatFactViewModel : ViewModel() {

    val catFactResult = MutableLiveData<CatFactData>()

    fun catFact() {

        viewModelScope.launch(IO) {
            val response = CatFactRepository.catFact()
            if (response?.isSuccessful == true) {
                catFactResult.postValue(response.body())
            } else {
                Log.e("ERROR", "Could not start network call")

            }
        }
    }
}