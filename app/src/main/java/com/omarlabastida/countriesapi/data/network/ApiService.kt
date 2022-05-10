package com.omarlabastida.countriesapi.data.network

import com.omarlabastida.countriesapi.data.model.CountriesData
import com.omarlabastida.countriesapi.data.model.RequestDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiService {

    @POST("api/Utilidades/Pais_GetPais")
    suspend fun getCountries(@Body requestDto : RequestDto): Response<CountriesData>
}