package com.example.finalpizzadeliveryapp.domain.usecases.list

import com.example.finalpizzadeliveryapp.domain.DeliveryRepository
import javax.inject.Inject

class GetDesertListUseCase @Inject constructor(private val repository: DeliveryRepository) {
    operator fun invoke() = repository.getDesertList()
}