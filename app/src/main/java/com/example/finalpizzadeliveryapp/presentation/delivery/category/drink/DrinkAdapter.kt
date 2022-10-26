package com.example.finalpizzadeliveryapp.presentation.delivery.category.drink

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.data.network.entity.Drink
import com.example.finalpizzadeliveryapp.domain.model.DrinkModel
import kotlinx.android.synthetic.main.delivery_item.view.*

class DrinkAdapter: ListAdapter<Drink, DrinkAdapter.DrinkViewHolder>(DrinkItemDiffUtilCallback()) {
    inner class DrinkViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        return DrinkViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.delivery_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        holder.itemView.apply {
            item_title.text = currentList[position].title
            item_description.text = currentList[position].description
            item_price.text = currentList[position].price
            Glide.with(this).load(currentList[position].image).into(item_img)
        }
    }

    class DrinkItemDiffUtilCallback: DiffUtil.ItemCallback<Drink>() {
        override fun areItemsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Drink, newItem: Drink): Boolean {
            return oldItem == newItem
        }
    }
}