package com.example.kotlinapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.FlowerModel
import com.example.kotlinapp.databinding.ItemFlowerBinding


class FlowerAdapter(
    private var arrayListFlowers: ArrayList<FlowerModel>, val onFlowerClick: (FlowerModel) -> Unit)
    : RecyclerView.Adapter<FlowerAdapter.FlowerViewHolder>() {

//24.50

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowerViewHolder {
        return FlowerViewHolder(
            ItemFlowerBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: FlowerViewHolder, position: Int) {
        holder.onBind(arrayListFlowers[position])
        holder.itemView.setOnClickListener{
            onFlowerClick(arrayListFlowers[position])
        }
    }

    override fun getItemCount(): Int {
       return  arrayListFlowers.size
    }

    class FlowerViewHolder(private val binding: ItemFlowerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(flower: FlowerModel) {
            binding.textView.text = flower.name + "\n\n Price: " + flower.price.toString() + "€"
            binding.imageView.setImageResource(flower.image)
        }
    }

}




