package com.example.finalpizzadeliveryapp.data.network.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finalpizzadeliveryapp.domain.model.DrinkModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "drink_table")
data class Drink(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val description: String,
    val image: String,
    val price: String,
    val title: String
): Parcelable

