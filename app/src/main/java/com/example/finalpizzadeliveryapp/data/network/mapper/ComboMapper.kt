package com.example.finalpizzadeliveryapp.data.network.mapper

import com.example.finalpizzadeliveryapp.data.network.entity.Combo
import com.example.finalpizzadeliveryapp.domain.model.ComboModel
import com.example.finalpizzadeliveryapp.data.network.entity.DeliveryResponse
import com.example.finalpizzadeliveryapp.domain.utils.EntityMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

class ComboMapper @Inject constructor(): EntityMapper<Combo, ComboModel> {
    override fun mapFromEntity(entity: Combo): ComboModel {
        return ComboModel(
            id = entity.id,
            title = entity.title,
            description = entity.description,
            image = entity.image,
            price = entity.price
        )
    }

    override fun mapToEntity(domainModel: ComboModel): Combo {
        return Combo(
            id = domainModel.id,
            title = domainModel.title,
            description = domainModel.description,
            image = domainModel.image,
            price = domainModel.price
        )
    }

    fun mapResponseToList(entity: Response<DeliveryResponse>): List<Combo> {
        return entity.body()!!.combo
    }

    fun toDomainList(initial: List<Combo>): List<ComboModel>{
        return initial.map { mapFromEntity(it) }
    }

    fun mapFlow(entity: Flow<List<Combo>>): Flow<List<ComboModel>> {
        return entity.map { toDomainList(it) }
    }



}