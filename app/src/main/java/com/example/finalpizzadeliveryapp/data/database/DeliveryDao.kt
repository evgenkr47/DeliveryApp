package com.example.finalpizzadeliveryapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.finalpizzadeliveryapp.data.network.entity.Combo
import com.example.finalpizzadeliveryapp.data.network.entity.Desert
import com.example.finalpizzadeliveryapp.data.network.entity.Drink
import com.example.finalpizzadeliveryapp.data.network.entity.Pizza
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDao {

    // Pizza
    @Query("SELECT * FROM pizza_table")
    fun getAllPizza(): Flow<List<Pizza>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPizzas(pizza: List<Pizza>)

    @Query("DELETE FROM pizza_table")
    suspend fun deleteAllPizzas()

    @Query("SELECT * FROM pizza_table WHERE id == :id")
    fun getPizzaInfo(id: Int): Pizza


    //Combo
    @Query("SELECT * FROM combo_table")
    fun getAllCombo(): Flow<List<Combo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCombos(combo: List<Combo>)

    @Query("DELETE FROM combo_table")
    suspend fun deleteAllCombos()

    @Query("SELECT * FROM combo_table WHERE id == :id")
    fun getComboInfo(id: Int): Combo

    //Drink
    @Query("SELECT * FROM drink_table")
    fun getAllDrink(): Flow<List<Drink>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDrinks(drink: List<Drink>)

    @Query("DELETE FROM drink_table")
    suspend fun deleteAllDrinks()

    @Query("SELECT * FROM drink_table WHERE id == :id")
    fun getDrinkInfo(id: Int): Drink

    //Desert
    @Query("SELECT * FROM desert_table")
    fun getAllDesert(): Flow<List<Desert>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeserts(desert: List<Desert>)

    @Query("DELETE FROM desert_table")
    suspend fun deleteAllDeserts()

    @Query("SELECT * FROM desert_table WHERE id == :id")
    fun getDesertInfo(id: Int): Desert
}