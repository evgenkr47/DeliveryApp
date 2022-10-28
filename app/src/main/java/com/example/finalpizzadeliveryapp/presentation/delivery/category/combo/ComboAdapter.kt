package com.example.finalpizzadeliveryapp.presentation.delivery.category.combo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.data.network.entity.Combo
import com.example.finalpizzadeliveryapp.domain.model.ComboModel
import kotlinx.android.synthetic.main.delivery_item.view.*

class ComboAdapter: ListAdapter<ComboModel, ComboAdapter.ComboViewHolder>(ComboItemDiffUtilCallback()) {
    inner class ComboViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComboViewHolder {
        return ComboViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.delivery_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ComboViewHolder, position: Int) {
        holder.itemView.apply {
            item_title.text = currentList[position].title
            item_description.text = currentList[position].description
            item_price.text = currentList[position].price
            Glide.with(this).load(currentList[position].image).into(item_img)
        }
    }

    class ComboItemDiffUtilCallback: DiffUtil.ItemCallback<ComboModel>() {
        override fun areItemsTheSame(oldItem: ComboModel, newItem: ComboModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ComboModel, newItem: ComboModel): Boolean {
            return oldItem == newItem
        }

    }
}