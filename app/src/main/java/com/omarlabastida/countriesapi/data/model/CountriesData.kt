package com.omarlabastida.countriesapi.data.model

data class   CountriesData(
    val Fecha: String,
    val ID: String,
    val IsActionPermitted: Boolean,
    val IsExists: Boolean,
    val IsOk: Boolean,
    val IsOnline: Boolean,
    val Mensaje: String,
    val MensajeID: Int,
    val NoFilas: Int,
    val Nota: String,
    val Password: Any,
    val Permiso: Boolean,
    val TipoUsuario: Any,
    val URL: String,
    val UserName: String,
    val dsRespuesta: DsRespuesta
)