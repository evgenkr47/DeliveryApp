package com.example.finalpizzadeliveryapp.domain

import com.example.finalpizzadeliveryapp.domain.model.ComboModel
import com.example.finalpizzadeliveryapp.domain.model.DesertModel
import com.example.finalpizzadeliveryapp.domain.model.DrinkModel
import com.example.finalpizzadeliveryapp.domain.model.PizzaModel
import com.example.finalpizzadeliveryapp.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {



    fun getPizzaList(): Flow<Resource<List<PizzaModel>>>
    fun getDrinkList(): Flow<Resource<List<DrinkModel>>>
    fun getDesertList(): Flow<Resource<List<DesertModel>>>
    fun getComboList(): Flow<Resource<List<ComboModel>>>

    fun getPizzaInfo(id: Int): PizzaModel
    fun getDrinkInfo(id: Int): DrinkModel
    fun getComboInfo(id: Int): ComboModel
    fun getDesertInfo(id: Int): DesertModel
}