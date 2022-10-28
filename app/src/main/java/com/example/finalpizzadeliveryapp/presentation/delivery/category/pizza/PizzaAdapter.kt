package com.example.finalpizzadeliveryapp.presentation.delivery.category.pizza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.data.network.entity.Pizza
import com.example.finalpizzadeliveryapp.domain.model.PizzaModel
import kotlinx.android.synthetic.main.delivery_item.view.*

class PizzaAdapter: ListAdapter<PizzaModel, PizzaAdapter.PizzaViewHolder>(PizzaItemDiffUtilCallback()) {
    inner class PizzaViewHolder(view: View): RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.delivery_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.itemView.apply {
            item_title.text = currentList[position].title
            item_description.text = currentList[position].description
            item_price.text = currentList[position].price
            Glide.with(this).load(currentList[position].image).into(item_img)
        }
    }

    class PizzaItemDiffUtilCallback: DiffUtil.ItemCallback<PizzaModel>() {
        override fun areItemsTheSame(oldItem: PizzaModel, newItem: PizzaModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PizzaModel, newItem: PizzaModel): Boolean {
            return oldItem == newItem
        }

    }


}