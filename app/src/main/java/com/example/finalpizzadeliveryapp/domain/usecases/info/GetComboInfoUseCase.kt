package com.example.finalpizzadeliveryapp.domain.usecases.info

import com.example.finalpizzadeliveryapp.domain.DeliveryRepository
import javax.inject.Inject

class GetComboInfoUseCase @Inject constructor(private val repository: DeliveryRepository) {
    operator fun invoke(id: Int) = repository.getComboInfo(id)
}