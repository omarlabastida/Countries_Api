package com.omarlabastida.countriesapi.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.omarlabastida.countriesapi.R
import com.omarlabastida.countriesapi.data.model.Paise

class CountriesAdapter (val countries: List<Paise>, private val itemClickListener: onCountryClickListener): RecyclerView.Adapter<CountriesAdapter.ViewHolder>(){


    interface onCountryClickListener{
        fun onRecyclerClick(country: Paise)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.view_countries, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        val itemClick:onCountryClickListener = itemClickListener
        holder.bind(country,itemClick)
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var nameCountry = view.findViewById<TextView>(R.id.nameCountry)
        private var check = view.findViewById<ImageView>(R.id.check)
        fun bind (country: Paise, itemClick: onCountryClickListener){
            check.isVisible = false
            nameCountry.text = country.Pais

            itemView.setOnClickListener{
                check.isVisible= true
                itemClick.onRecyclerClick(country)

            }
        }
    }
}