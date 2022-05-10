package com.omarlabastida.countriesapi.data.network

import com.omarlabastida.countriesapi.core.GetRetrofit.getRetrofit
import com.omarlabastida.countriesapi.data.model.Paise
import com.omarlabastida.countriesapi.data.model.RequestDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountrySearch {

    private val retrofit = getRetrofit()

    suspend fun countriesSearch(): List<Paise>{// Aqui se van a buscar los paises
        return withContext(Dispatchers.IO){
            val requestDto: RequestDto = RequestDto("")//Creación del objeto para la petición POST
            val call=retrofit.create(ApiService::class.java).getCountries(requestDto)
            call.body()?.dsRespuesta?.Paises ?: emptyList()
        }
    }
}