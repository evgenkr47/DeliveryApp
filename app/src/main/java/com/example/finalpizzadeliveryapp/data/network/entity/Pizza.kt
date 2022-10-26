package com.example.finalpizzadeliveryapp.data.network.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finalpizzadeliveryapp.domain.model.PizzaModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "pizza_table")
data class Pizza(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val description: String,
    val image: String,
    val price: String,
    val title: String
): Parcelable

