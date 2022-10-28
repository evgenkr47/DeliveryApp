package com.example.finalpizzadeliveryapp.presentation.delivery.category.desert

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalpizzadeliveryapp.R
import com.example.finalpizzadeliveryapp.data.network.entity.Desert
import com.example.finalpizzadeliveryapp.domain.model.DesertModel
import kotlinx.android.synthetic.main.delivery_item.view.*

class DesertAdapter: ListAdapter<DesertModel, DesertAdapter.DesertViewHolder>(DesertItemDiffUtilCallback()) {
    inner class DesertViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesertViewHolder {
        return DesertViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.delivery_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DesertViewHolder, position: Int) {
        holder.itemView.apply {
            item_title.text = currentList[position].title
            item_description.text = currentList[position].description
            item_price.text = currentList[position].price
            Glide.with(this).load(currentList[position].image).into(item_img)
        }
    }

    class DesertItemDiffUtilCallback: DiffUtil.ItemCallback<DesertModel>() {
        override fun areItemsTheSame(oldItem: DesertModel, newItem: DesertModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DesertModel, newItem: DesertModel): Boolean {
            return oldItem == newItem
        }
    }
}