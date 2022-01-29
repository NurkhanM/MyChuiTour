package com.md.nurkhan.chuitour.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.md.nurkhan.chuitour.R
import com.md.nurkhan.chuitour.adapters.MyRecyclerAdater
import com.md.nurkhan.chuitour.models.ChuiTourModels

class HotelFragment : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ChuiTourModels>

    lateinit var imageID: Array<Int>
    lateinit var nametxt: Array<String>
    lateinit var nametxt2: Array<String>
    lateinit var nametxt3: Array<String>
    lateinit var nametxt4: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_hotel, container, false)

        imageID = arrayOf(
            R.drawable.grand_hotel_burana,
            R.drawable.jekshen,
            R.drawable.prime_time,
            R.drawable.jannat,
            R.drawable.maryotel,
            R.drawable.futuro,
            R.drawable.crocus,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel,
            R.drawable.resident_hotel
        )

        nametxt = arrayOf(
            getString(R.string.grand_otel_burana),
            getString(R.string.grand_otel_jekshen),
            getString(R.string.hotel_prime_time),
            getString(R.string.hotel_janat),
            getString(R.string.hotel_maryotel),
            getString(R.string.hotel_futuro),
            getString(R.string.hotel_crocus),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident),
            getString(R.string.hotel_resident)
        )

        nametxt2 = arrayOf(
            getString(R.string.burana_location_hotel),
            getString(R.string.location_jekshen),
            getString(R.string.prime_time_location_hotel),
            getString(R.string.janat_location_hotel),
            getString(R.string.maryotel_location_hotel),
            getString(R.string.futuro_location_hotel),
            getString(R.string.crocus_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel),
            getString(R.string.resident_location_hotel)
        )
        nametxt3 = arrayOf(
            getString(R.string.burana_som),
            getString(R.string.jeskshen_som),
            getString(R.string.prime_time_som),
            getString(R.string.janat_som),
            getString(R.string.maryotel_som),
            getString(R.string.futuro_som),
            getString(R.string.crocus_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som),
            getString(R.string.resident_som)
        )

        nametxt4 = arrayOf(
            getString(R.string.des_burana),
            getString(R.string.des_hotel_jekshen),
            getString(R.string.des_prime_time),
            getString(R.string.des_hotel_janat),
            getString(R.string.des_hotel_maryotel),
            getString(R.string.des_hotel_futuro),
            getString(R.string.des_hotel_crocus),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident),
            getString(R.string.des_hotel_resident)
        )

        newRecyclerView = view.findViewById(R.id.recyclerView2)
        newRecyclerView.layoutManager = LinearLayoutManager(view.context)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ChuiTourModels>()
        getUserData()
        // Inflate the layout for this fragment

        return view
    }

    private fun getUserData() {
        for (i in imageID.indices){

            val news = ChuiTourModels(imageID[i], nametxt[i], nametxt2[i], nametxt3[i] )
            newArrayList.add(news)

        }

        val adater = MyRecyclerAdater(newArrayList)
        newRecyclerView.adapter = adater
        adater.setItemOnClickListnear(object : MyRecyclerAdater.onitemClickListnear{
            override fun onItemClick(position: Int) {


                val bundle = Bundle()
                bundle.putString("nameTxt", newArrayList[position].name)
                bundle.putString("nameTxt2", nametxt2[position])
                bundle.putString("nameTxt3", nametxt3[position])
                bundle.putString("nameTxt4", nametxt4[position])
                bundle.putInt("imgId", newArrayList[position].image)
                val fragment = DetalFragment()
                fragment.arguments = bundle
                getFragmentManager()?.beginTransaction()?.remove(this@HotelFragment)?.replace(R.id.constraintlayout, fragment)?.addToBackStack(null)?.commit()

            }
        })


    }

}