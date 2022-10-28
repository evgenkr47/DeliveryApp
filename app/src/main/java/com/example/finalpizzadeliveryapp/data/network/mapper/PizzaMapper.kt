package com.example.finalpizzadeliveryapp.data.network.mapper

import com.example.finalpizzadeliveryapp.data.network.entity.Pizza
import com.example.finalpizzadeliveryapp.data.network.entity.DeliveryResponse
import com.example.finalpizzadeliveryapp.domain.model.PizzaModel
import com.example.finalpizzadeliveryapp.domain.utils.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class PizzaMapper @Inject constructor() : EntityMapper<Pizza, PizzaModel> {
    override fun mapFromEntity(entity: Pizza): PizzaModel {
        return PizzaModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            image = entity.image,
            price = entity.price
        )
    }

    override fun mapToEntity(domainModel: PizzaModel): Pizza {
        return Pizza(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            image = domainModel.image,
            price = domainModel.price
        )
    }

    fun toDomainList(initial: List<Pizza>): List<PizzaModel>{
        return initial.map { mapFromEntity(it) }
    }


    fun mapResponseToList(entity: Response<DeliveryResponse>): List<Pizza> {
        return entity.body()!!.pizza
    }


    fun mapFlow(entity: Flow<List<Pizza>>): Flow<List<PizzaModel>>{
        return entity.map { toDomainList(it) }
    }




}