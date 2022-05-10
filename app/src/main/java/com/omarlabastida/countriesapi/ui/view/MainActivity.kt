package com.omarlabastida.countriesapi.ui.view

import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.omarlabastida.countriesapi.ui.viewmodel.ViewModel
import com.omarlabastida.countriesapi.R
import com.omarlabastida.countriesapi.data.adapter.CountriesAdapter
import com.omarlabastida.countriesapi.data.model.Paise

class MainActivity : AppCompatActivity(), CountriesAdapter.onCountryClickListener {

    private lateinit var adapter: CountriesAdapter//Declaración del adapter
    private lateinit var recyclerView: RecyclerView//Declaración para la vista del Recycler View

    private val countriesViewModel: ViewModel by viewModels() //View Model
    private val countriesList= mutableListOf<Paise>()//Lista movieList de tipo Paise para el recyclerView
    private var connection: Boolean = false//Variable para el test de conexión

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)//RecyclerView

        connection()//Test de conexíon a internet

        if (connection==true){
            countriesViewModel.onCreate()
        }

        countriesViewModel.countriesModel.observe(this, Observer {
            countriesList.addAll(it)
            adapter.notifyDataSetChanged()
            recyclerView() })

        recyclerView()//llamada al recyclerView

    }

    //Funcion para desplegar el recyclerView
    fun recyclerView() {
        adapter = CountriesAdapter(countriesList, this)
        var layoutManager = GridLayoutManager(this, 1)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter= adapter
    }

    //Funcion de click en un pais
    override fun onRecyclerClick(country: Paise) {
        val intent= Intent(this, CountryFeatures::class.java)
        intent.putExtra("nameCountry", country.Pais)
        startActivity(intent)
    }

    //Función para test de conexión a internet
    fun connection(){
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            connection = true
        }else {
            Toast.makeText(this,"SIN CONEXION A INTERNET", Toast.LENGTH_SHORT).show()
            connection = false
        }
    }

}