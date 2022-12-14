package com.example.healthify

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.healthify.databinding.CardCellBinding
import com.example.healthify.WorkoutData

class HomeWorkAdapter (
    private val workouts: MutableList<WorkoutData>,

    ) :
    RecyclerView.Adapter<HomeWorkViewHolder >() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeWorkViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = CardCellBinding.inflate(from, parent, false)
        return HomeWorkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeWorkViewHolder , position: Int) {

        holder.bindWork(workouts[position])
    }

    override fun getItemCount(): Int {
        return workouts.size
    }

}
