package com.example.finalpizzadeliveryapp.data.network.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.finalpizzadeliveryapp.domain.model.DesertModel
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "desert_table")
@Parcelize
data class Desert(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo
    val description: String,
    val image: String,
    val price: String,
    val title: String
):Parcelable

