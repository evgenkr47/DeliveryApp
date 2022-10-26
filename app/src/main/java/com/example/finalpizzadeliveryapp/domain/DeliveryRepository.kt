package com.example.finalpizzadeliveryapp.domain

import com.example.finalpizzadeliveryapp.data.network.entity.Combo
import com.example.finalpizzadeliveryapp.data.network.entity.Desert
import com.example.finalpizzadeliveryapp.data.network.entity.Drink
import com.example.finalpizzadeliveryapp.data.network.entity.Pizza
import com.example.finalpizzadeliveryapp.domain.model.*
import com.example.finalpizzadeliveryapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DeliveryRepository {



    fun getPizzaList(): Flow<Resource<List<Pizza>>>
    fun getDrinkList(): Flow<Resource<List<Drink>>>
    fun getDesertList(): Flow<Resource<List<Desert>>>
    fun getComboList(): Flow<Resource<List<Combo>>>

    fun getPizzaInfo(id: Int): PizzaModel
    fun getDrinkInfo(id: Int): DrinkModel
    fun getComboInfo(id: Int): ComboModel
    fun getDesertInfo(id: Int): DesertModel
}