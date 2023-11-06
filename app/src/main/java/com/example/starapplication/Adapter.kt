package com.example.starapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.starapplication.Responses
import com.example.starapplication.ResultsItem


class Adapter : ListAdapter<ResultsItem, Adapter.MyViewHolder>(DIFF_CALLBACK) {

    // Tetapkan DIFF_CALLBACK
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ResultsItem>() {
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.name.text = item.name
        holder.gender.text = item.gender
        holder.birth_year.text = item.birthYear
        holder.skin_color.text = item.skinColor
        holder.eye_color.text = item.eyeColor
        holder.height.text = item.height
    }
}
