package com.md.nurkhan.chuitour.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.md.nurkhan.chuitour.R
import com.md.nurkhan.chuitour.models.ChuiTourModels

class MyRecyclerAdater(private val myList: ArrayList<ChuiTourModels>):
    RecyclerView.Adapter<MyRecyclerAdater.MyViewHolder>() {

    private lateinit var mListnear: onitemClickListnear

    interface onitemClickListnear{
        fun onItemClick(position: Int)
    }

    fun setItemOnClickListnear(listnear: onitemClickListnear){
        mListnear = listnear
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,
        parent, false)
        return MyViewHolder(itemView, mListnear)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         val correntItem = myList[position]
        holder.txtTextView.text = correntItem.name
        holder.txtTextView2.text = correntItem.name2
        holder.txtTextView3.text = correntItem.name3
        holder.imgShImageView.setImageResource(correntItem.image)
    }

    override fun getItemCount(): Int {
       return myList.size
    }

    class MyViewHolder(itemView: View, listnear: onitemClickListnear): RecyclerView.ViewHolder(itemView) {

        val txtTextView: TextView = itemView.findViewById(R.id.txt)
        val txtTextView2: TextView = itemView.findViewById(R.id.txt2)
        val txtTextView3: TextView = itemView.findViewById(R.id.txt3)
        val imgShImageView: ShapeableImageView = itemView.findViewById(R.id.img)

        init {
            itemView.setOnClickListener {
                listnear.onItemClick(adapterPosition)
            }
        }


    }
}