package com.example.finalpizzadeliveryapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.finalpizzadeliveryapp.data.network.entity.Combo
import com.example.finalpizzadeliveryapp.data.network.entity.Desert
import com.example.finalpizzadeliveryapp.data.network.entity.Drink
import com.example.finalpizzadeliveryapp.data.network.entity.Pizza

@Database(
    entities = [Pizza::class, Drink::class, Desert::class, Combo::class],
    version = 1,
    exportSchema = true
)
abstract class DeliveryDataBase: RoomDatabase() {
    abstract fun getDeliveryDao(): DeliveryDao
}