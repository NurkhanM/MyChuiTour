package com.md.nurkhan.chuitour.fragments

import android.content.ContentValues.TAG
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.md.nurkhan.chuitour.R

class DetalFragment : Fragment() {

    private lateinit var imageView: ImageView
    lateinit var nameDetal: TextView
    var uriString: String = "https://goo.gl/maps/vKWgMXZ7eq7EaN4G6"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  view = inflater.inflate(R.layout.fragment_detal, container, false)

        nameDetal = view.findViewById(R.id.txtDetal)
        val nameDetal2 : TextView = view.findViewById(R.id.txtDetal2)
        val nameDetal3 : TextView = view.findViewById(R.id.txtDetal3)
        val nameDetal4 : TextView = view.findViewById(R.id.txtDetal4)
        val imgDetal : ImageView = view.findViewById(R.id.imgDetal)
        imageView = view.findViewById(R.id.imgDetallocation)

        imageView.setOnClickListener {
            Log.e(TAG, "onCreateView=============: " +  nameDetal.text )
//            var uriString = "https://goo.gl/maps/vKWgMXZ7eq7EaN4G6"
            val uri = Uri.parse(getLocation2Gis())
            val locationintent = Intent(Intent.ACTION_VIEW, uri)
//            locationintent.setPackage("com.google.android.apps.maps")
            startActivity(locationintent)
        }

        val  args = this.arguments
        val name =  args?.get("nameTxt")
        val name2 =  args?.get("nameTxt2")
        val name3 =  args?.get("nameTxt3")
        val name4 =  args?.get("nameTxt4")
        val img =args?.get("imgId")


        nameDetal.text = name.toString()
        nameDetal2.text = name2.toString()
        nameDetal3.text = name3.toString()
        nameDetal4.text = name4.toString()
        imgDetal.setImageResource(img as Int)

        return view

    }

    fun getLocation2Gis(): String{
        if (nameDetal.text.equals("Башня Бурана")) {
            uriString = "https://go.2gis.com/c2cgl"
        }
        if (nameDetal.text.equals("Озеро Кель-Тор")) {
            uriString = "https://go.2gis.com/431ru3"
        }

        if (nameDetal.text.equals("Ущелье Кегеты")) {
            uriString = "https://go.2gis.com/t5xmw"
        }
        if (nameDetal.text.equals("СУУСАМЫРСКАЯ ДОЛИНА")) {
            uriString = "https://goo.gl/maps/q4JsTYLtT1PCBJsB9"
        }
        if (nameDetal.text.equals("Чон-Кемин")) {
            uriString = "https://go.2gis.com/7lktz5"
        }
        if (nameDetal.text.equals("Водопад Кара-Арча")) {
            uriString = "https://go.2gis.com/7jri8"
        }
        if (nameDetal.text.equals("Ата-Бейит")) {
            uriString = "https://go.2gis.com/88b9a0"
        }
        if (nameDetal.text.equals("Тянь-Шань")) {
            uriString = "https://goo.gl/maps/vKWgMXZ7eq7EaN4G6"
        }

        if (nameDetal.text.equals("Grand Hotel Burana")) {
            uriString = "https://go.2gis.com/7crdd"
        }

        if (nameDetal.text.equals("Гостевой дом Jekshen")) {
            uriString = "https://goo.gl/maps/6tsHsYv6yqxgxjsh8"
        }
        if (nameDetal.text.equals("Hotel Prime Time")) {
            uriString = "https://go.2gis.com/ma368"
        }
        if (nameDetal.text.equals("Jannat Resort")) {
            uriString = "https://go.2gis.com/rszfv"
        }
        if (nameDetal.text.equals("Отель Maryotel")) {
            uriString = "https://go.2gis.com/sbsjh"
        }
        if (nameDetal.text.equals("Futuro Hotel")) {
            uriString = "https://go.2gis.com/cxwpnz"
        }
        if (nameDetal.text.equals("Guest House Crocus")) {
            uriString = "https://go.2gis.com/o39gwo"
        }
        if (nameDetal.text.equals("Resident Hotel Bishkek")) {
            uriString = "https://go.2gis.com/0kjowj"
        }

        return uriString
    }

}