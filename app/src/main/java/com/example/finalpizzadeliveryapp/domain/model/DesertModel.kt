package com.example.finalpizzadeliveryapp.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

data class DesertModel(
    val id: Int,
    val description: String,
    val image: String,
    val price: String,
    val title: String
)