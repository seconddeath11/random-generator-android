package com.example.randomgenerator.options.dice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.randomgenerator.R

class DiceViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val diceImage: ImageView = itemView.findViewById(R.id.dice_image)

    fun bind(item: Int) {
        diceImage.setImageResource(when (item) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        })
    }

    companion object {
        fun from(parent: ViewGroup): DiceViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater
                .inflate(R.layout.list_item_dice, parent, false)
            return DiceViewHolder(view)
        }
    }
}

class DiceAdapter : RecyclerView.Adapter<DiceViewHolder>() {

    var data = listOf<Int>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DiceViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceViewHolder {
        return DiceViewHolder.from(parent)
    }
}