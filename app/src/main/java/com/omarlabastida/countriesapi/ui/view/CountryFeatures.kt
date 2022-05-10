package com.omarlabastida.countriesapi.ui.view

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.omarlabastida.countriesapi.R

class CountryFeatures : AppCompatActivity() {

    private lateinit var fusedLocation: FusedLocationProviderClient//Variable para ubicación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_features)

        fusedLocation = LocationServices.getFusedLocationProviderClient(this)

        var titleSup = findViewById<TextView>(R.id.titleSup)
        var titleInf = findViewById<TextView>(R.id.titleInf)

        var nameCountry=intent.getStringExtra("nameCountry")//obtencion del nombre del pais

        titleSup.text = "Click, $nameCountry!"//impreión del nombre superior
        titleInf.text = "Has dado clic en el estado de ($nameCountry)"// impresion del nombre inferior



    }

    // llamada al boton back para iniciar una aplicación de navegación
    override fun onBackPressed() {
        //Solicitud de permisos de ubicación actual
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION
        )!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
            return
        }

        //Redirección a una aplicacion de navegación
        fusedLocation.lastLocation.addOnSuccessListener {
            if(it!= null){

                val actualLocation= "geo:${it.latitude}, ${it.longitude}"// Aqui se agrega la ubicación actual
                super.onBackPressed()
                val uriMap = Uri.parse(actualLocation)
                val intent = Intent(Intent.ACTION_VIEW, uriMap)
                if (intent.resolveActivity(packageManager)!=null){
                    startActivity(intent)
                }
            }
        }










    }
}