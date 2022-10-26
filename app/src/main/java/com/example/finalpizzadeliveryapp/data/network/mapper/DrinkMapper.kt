package com.example.finalpizzadeliveryapp.data.network.mapper

import com.example.finalpizzadeliveryapp.data.network.entity.DeliveryResponse
import com.example.finalpizzadeliveryapp.data.network.entity.Desert
import com.example.finalpizzadeliveryapp.data.network.entity.Drink
import com.example.finalpizzadeliveryapp.domain.model.DrinkModel
import com.example.finalpizzadeliveryapp.domain.util.EntityMapper
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




}