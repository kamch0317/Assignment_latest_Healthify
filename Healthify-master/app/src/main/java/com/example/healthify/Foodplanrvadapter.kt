package com.example.healthify

import Healthify.databinding.SinglecolumnBinding
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Foodplanrvadapter (private val context: Context, private val foodlist : ArrayList<FoodData>,itemListener : onFoodItemClickListener) : RecyclerView.Adapter<Foodplanrvadapter.ViewHolder>(){

    private var mListener: onFoodItemClickListener = itemListener

    interface onFoodItemClickListener{

        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onFoodItemClickListener){

        mListener = listener
    }

    inner class ViewHolder(val binding: SinglecolumnBinding, listener: onFoodItemClickListener) : RecyclerView.ViewHolder(binding.root){

        init {

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val listener = mListener
        val binding = SinglecolumnBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(foodlist[position]){
                Glide.with(context).load(image).into(binding.foodImage)
                binding.foodText.text = this.setName
                binding.foodDescription.text = this.setDesc
            }
        }
    }

    override fun getItemCount(): Int {
        return foodlist.size
    }

}