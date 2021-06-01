package com.example.dataproject.helpers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dataproject.R
import com.example.dataproject.models.MyCat

class CatAdapter(private val countriesList: List<MyCat>) :RecyclerView.Adapter<CatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.cat_recycler,parent,false)
        return ViewHolder(view)
    }


    override fun getItemCount(): Int {

        return countriesList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Response", "List Count :${countriesList.size} ")


        return holder.bind(countriesList[position])

    }
    class ViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView) {


        var text1= itemView.findViewById<TextView>(R.id.text1)
        fun bind(cat: MyCat) {
            text1.text = cat.text
        }

    }
}