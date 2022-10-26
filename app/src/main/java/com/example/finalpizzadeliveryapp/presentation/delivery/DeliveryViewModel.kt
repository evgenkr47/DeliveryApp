package com.example.finalpizzadeliveryapp.presentation.delivery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.finalpizzadeliveryapp.domain.usecases.DeliveryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DeliveryViewModel @Inject constructor(
    private val deliveryUseCases: DeliveryUseCases,


): ViewModel() {

    val pizza = deliveryUseCases.getPizzaListUseCase().asLiveData()

    val combo = deliveryUseCases.getComboListUseCase().asLiveData()

    val drink = deliveryUseCases.getDrinkListUseCase().asLiveData()

    val desert = deliveryUseCases.getDesertListUseCase().asLiveData()

}


