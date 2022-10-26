package com.example.finalpizzadeliveryapp.domain.usecases

import com.example.finalpizzadeliveryapp.domain.usecases.info.GetComboInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetDesertInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetDrinkInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetPizzaInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetComboListUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetDesertListUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetDrinkListUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetPizzaListUseCase

data class DeliveryUseCases(
    val getComboListUseCase: GetComboListUseCase,
    val getPizzaListUseCase: GetPizzaListUseCase,
    val getDrinkListUseCase: GetDrinkListUseCase,
    val getDesertListUseCase: GetDesertListUseCase,
    val getPizzaInfoUseCase: GetPizzaInfoUseCase,
    val getDrinkInfoUseCase: GetDrinkInfoUseCase,
    val getDesertInfoUseCase: GetDesertInfoUseCase,
    val getComboInfoUseCase: GetComboInfoUseCase,
)
