package com.example.finalpizzadeliveryapp.data.network.entity

import com.example.finalpizzadeliveryapp.domain.model.ComboModel
import com.example.finalpizzadeliveryapp.domain.model.DesertModel
import com.example.finalpizzadeliveryapp.domain.model.DrinkModel
import com.example.finalpizzadeliveryapp.domain.model.PizzaModel

data class DeliveryResponse(
    val combo: List<Combo>,
    val deserts: List<Desert>,
    val drinks: List<Drink>,
    val pizza: List<Pizza>,
)