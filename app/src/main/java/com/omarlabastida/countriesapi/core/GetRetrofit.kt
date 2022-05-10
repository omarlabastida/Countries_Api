package com.omarlabastida.countriesapi.core


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GetRetrofit {

    private const val URL_BASE = "https://weepatient.com/API/"//URL Base de la api

    fun getRetrofit(): Retrofit { //Funcion para llamada a retrofit
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(URL_BASE)
            .build()
    }
}