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

class RestoranFragment : Fragment() {
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
        val view =  inflater.inflate(R.layout.fragment_restoran, container, false)
        imageID = arrayOf(
            R.drawable.dubrovskii,
            R.drawable.supara,
            R.drawable.sakura,
            R.drawable.hawaii,
            R.drawable.altyn_kazyna,
            R.drawable.traktyr,
            R.drawable.park,
            R.drawable.siklon,
            R.drawable.park,
            R.drawable.altyn_kazyna,
            R.drawable.dubrovskii,
            R.drawable.park,
            R.drawable.sakura,
            R.drawable.sakura,
            R.drawable.altyn_kazyna,
            R.drawable.supara,
            R.drawable.altyn_kazyna,
            R.drawable.sakura,
            R.drawable.supara,
            R.drawable.supara
        )

        nametxt = arrayOf(
            getString(R.string.dubrovski),
            getString(R.string.supara),
            getString(R.string.sakura),
            getString(R.string.hawaiii),
            getString(R.string.altyn_hazyna),
            getString(R.string.traktyr),
            getString(R.string.park),
            getString(R.string.siklon),
            getString(R.string.park),
            getString(R.string.altyn_hazyna),
            getString(R.string.dubrovski),
            getString(R.string.park),
            getString(R.string.sakura),
            getString(R.string.sakura),
            getString(R.string.altyn_hazyna),
            getString(R.string.supara),
            getString(R.string.altyn_hazyna),
            getString(R.string.sakura),
            getString(R.string.supara),
            getString(R.string.supara)
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
            getString(R.string.des_kol_tor),
            getString(R.string.des_kegety),
            getString(R.string.des_suusamyr),
            getString(R.string.des_chon_kemin),
            getString(R.string.des_kegety_vodopad),
            getString(R.string.des_ata_beit),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan),
            getString(R.string.des_tan_shan)
        )

        newRecyclerView = view.findViewById(R.id.recyclerView3)
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
                getFragmentManager()?.beginTransaction()?.remove(this@RestoranFragment)?.replace(R.id.constraintlayout, fragment)?.addToBackStack(null)?.commit()

            }
        })


    }

}