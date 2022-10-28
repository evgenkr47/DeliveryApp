package com.example.finalpizzadeliveryapp.data.network.mapper

import com.example.finalpizzadeliveryapp.data.network.entity.DeliveryResponse
import com.example.finalpizzadeliveryapp.data.network.entity.Drink
import com.example.finalpizzadeliveryapp.domain.model.DrinkModel
import com.example.finalpizzadeliveryapp.domain.utils.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class DrinkMapper @Inject constructor(): EntityMapper<Drink, DrinkModel> {
    override fun mapFromEntity(entity: Drink): DrinkModel {
        return DrinkModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            image = entity.image,
            price = entity.price
        )
    }

    override fun mapToEntity(domainModel: DrinkModel): Drink {
        return Drink(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            image = domainModel.image,
            price = domainModel.price
        )
    }

    fun mapResponseToList(entity: Response<DeliveryResponse>): List<Drink> {
        return entity.body()!!.drinks
    }

    fun toDomainList(initial: List<Drink>): List<DrinkModel>{
        return initial.map { mapFromEntity(it) }
    }

    fun mapFlow(entity: Flow<List<Drink>>): Flow<List<DrinkModel>> {
        return entity.map { toDomainList(it) }
    }




}