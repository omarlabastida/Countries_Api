package com.omarlabastida.countriesapi.ui.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.omarlabastida.countriesapi.data.model.Paise
import com.omarlabastida.countriesapi.data.network.CountrySearch
import kotlinx.coroutines.launch

class ViewModel : ViewModel(){

    var countriesModel = MutableLiveData<List<Paise>>()

    fun onCreate(){
        viewModelScope.launch {
            val countriesData: List<Paise> = CountrySearch().countriesSearch()
            println("la lista de paises es $countriesData")
            if(!countriesData.isNullOrEmpty()){
                countriesModel.postValue(countriesData)
            }
        }
    }



}