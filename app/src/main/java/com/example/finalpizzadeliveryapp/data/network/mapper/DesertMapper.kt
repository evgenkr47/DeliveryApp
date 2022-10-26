package com.example.finalpizzadeliveryapp.data.network.mapper

import com.example.finalpizzadeliveryapp.data.network.entity.Combo
import com.example.finalpizzadeliveryapp.data.network.entity.DeliveryResponse
import com.example.finalpizzadeliveryapp.data.network.entity.Desert
import com.example.finalpizzadeliveryapp.domain.model.DesertModel
import com.example.finalpizzadeliveryapp.domain.util.EntityMapper
import retrofit2.Response
import javax.inject.Inject

class DesertMapper @Inject constructor(): EntityMapper<Desert, DesertModel> {
    override fun mapFromEntity(entity: Desert): DesertModel {
        return DesertModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            image = entity.image,
            price = entity.price
        )
    }

    override fun mapToEntity(domainModel: DesertModel): Desert {
        return Desert(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            image = domainModel.image,
            price = domainModel.price
        )
    }

    fun mapResponseToList(entity: Response<DeliveryResponse>): List<Desert> {
        return entity.body()!!.deserts
    }




}