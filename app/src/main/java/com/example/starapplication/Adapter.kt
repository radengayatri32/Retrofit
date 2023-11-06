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
import com.example.starapplication.databinding.ItemCharacterBinding


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

    class MyViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        // Access views through binding
        val name: TextView = binding.itemName
        val gender: TextView = binding.itemGender
        val birthYear: TextView = binding.itemBirthYear
        val skinColor: TextView = binding.itemSkinColor
        val eyeColor: TextView = binding.itemEyeColor
        val height: TextView = binding.itemHeight
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.name.text = item.name
        holder.gender.text = item.gender
        holder.birthYear.text = item.birthYear
        holder.skinColor.text = item.skinColor
        holder.eyeColor.text = item.eyeColor
        holder.height.text = item.height
    }
}
