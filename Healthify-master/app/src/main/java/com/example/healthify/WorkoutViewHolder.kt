package com.example.healthify

import Healthify.databinding.CardCellBinding
import androidx.recyclerview.widget.RecyclerView

class WorkoutViewHolder(
    private val cardCellBinding: CardCellBinding,
    private val clickListener: OnWorkoutClickListener
) : RecyclerView.ViewHolder(cardCellBinding.root) {
    fun bindWork(workout: WorkoutData) {
        cardCellBinding.cover.setImageResource(workout.pic)
        cardCellBinding.title.text = workout.title
        cardCellBinding.author.text = workout.cmore

        cardCellBinding.cardView.setOnClickListener {
            clickListener.onClick(workout)
        }
    }
}


