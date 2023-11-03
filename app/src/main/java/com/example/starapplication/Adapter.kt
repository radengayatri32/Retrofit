package com.example.starapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class Adapter (val data: List<ResultsItem>): RecyclerView.Adapter<Adapter.MyViewHolder>() {
    class MyViewHolder (view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.item_name)
        val gender = view.findViewById<TextView>(R.id.item_gender)
        val birth_year = view.findViewById<TextView>(R.id.item_birth_year)
        val skin_color = view.findViewById<TextView>(R.id.item_skin_color)
        val eye_color = view.findViewById<TextView>(R.id.item_eye_color)
        val height = view.findViewById<TextView>(R.id.item_height)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (data != null){
            return data.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = data?.get(position)?.name
        holder.gender.text = data?.get(position)?.gender
        holder.birth_year.text = data?.get(position)?.birthYear
        holder.skin_color.text = data?.get(position)?.skinColor
        holder.eye_color.text = data?.get(position)?.eyeColor
        holder.height.text = data?.get(position)?.height


        }
    }

