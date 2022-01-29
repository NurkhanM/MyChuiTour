package com.md.nurkhan.chuitour.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.md.nurkhan.chuitour.fragments.Homeragment
import com.md.nurkhan.chuitour.fragments.HotelFragment
import com.md.nurkhan.chuitour.fragments.RestoranFragment

internal class MyAdapter(val contex: Context, fragmentM: FragmentManager, var totalTabs: Int): FragmentPagerAdapter(fragmentM){

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HotelFragment()
            1 -> Homeragment()
            2 -> RestoranFragment()
            else -> getItem(position)
        }
    }

    override fun getCount(): Int {
        return totalTabs
    }
}