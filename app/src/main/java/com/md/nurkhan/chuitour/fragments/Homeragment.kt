package com.md.nurkhan.chuitour.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.md.nurkhan.chuitour.R
import com.md.nurkhan.chuitour.adapters.MyRecyclerAdater
import com.md.nurkhan.chuitour.models.ChuiTourModels

class Homeragment : Fragment() {

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

        val  view = inflater.inflate(R.layout.fragment_homeragment, container, false)

        imageID = arrayOf(
            R.drawable.burana,
            R.drawable.kol_tor,
            R.drawable.kegety_korge,
            R.drawable.suusamyr,
            R.drawable.chon_kemin,
            R.drawable.kegety_vodopad,
            R.drawable.ata_beit,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan,
            R.drawable.tan_shan
        )

        nametxt = arrayOf(
            getString(R.string.burana),
            getString(R.string.kol_tor),
            getString(R.string.kegety_korge),
            getString(R.string.suusamyr),
            getString(R.string.chon_kemin),
            getString(R.string.kegety_vodopad),
            getString(R.string.ata_beit),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan),
            getString(R.string.tan_shan)
        )

        nametxt2 = arrayOf(
            getString(R.string.istoricheskie_dostopri),
            getString(R.string.vodoemy),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.nasional_park),
            getString(R.string.vodoemy),
            getString(R.string.istoricheskie_dostopri),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory),
            getString(R.string.gory)
        )
        nametxt3 = arrayOf(
            getString(R.string.bolee_1_2_chasa),
            getString(R.string.bolee_3_chasov),
            getString(R.string.bolee_3_chasov),
            getString(R.string.bolee_3_chasov),
            getString(R.string.bolee_3_chasov),
            getString(R.string.bolee_3_chasov),
            getString(R.string.bolee_1_chas),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov),
            getString(R.string.bolee_5_chasov)
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

        newRecyclerView = view.findViewById(R.id.recyclerView)
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
                getFragmentManager()?.beginTransaction()?.remove(this@Homeragment)?.replace(R.id.constraintlayout, fragment)?.addToBackStack(null)?.commit()

            }
        })


    }

}