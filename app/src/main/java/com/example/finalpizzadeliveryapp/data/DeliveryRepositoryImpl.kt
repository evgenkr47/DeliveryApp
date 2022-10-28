package com.example.finalpizzadeliveryapp.data

import com.example.finalpizzadeliveryapp.data.database.DeliveryDao
import com.example.finalpizzadeliveryapp.data.network.ApiService
import com.example.finalpizzadeliveryapp.data.network.mapper.*
import com.example.finalpizzadeliveryapp.domain.DeliveryRepository
import com.example.finalpizzadeliveryapp.domain.model.*
import com.example.finalpizzadeliveryapp.domain.utils.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class DeliveryRepositoryImpl @Inject constructor(
   private val apiService: ApiService,
   private val deliveryDao: DeliveryDao,
   private val deliveryMappers: DeliveryMappers

): DeliveryRepository {
    override fun getPizzaList() =
        networkBoundResource(
            query = {

                deliveryMappers.pizzaMapper.mapFlow(deliveryDao.getAllPizza())
            },
            fetch = {
                delay(2000)
                apiService.getDelivery()
            },
            saveFetchResult = {

                deliveryDao.deleteAllPizzas()
                deliveryDao.insertPizzas(deliveryMappers.pizzaMapper.mapResponseToList(it))
            }
        )



    override fun getDrinkList() =
        networkBoundResource(
            query = {
                deliveryMappers.drinkMapper.mapFlow(deliveryDao.getAllDrink())
            },
            fetch = {
                delay(2000)
                apiService.getDelivery()
            },
            saveFetchResult = {

                deliveryDao.deleteAllDrinks()
                deliveryDao.insertDrinks(deliveryMappers.drinkMapper.mapResponseToList(it))
            }
        )


    override fun getDesertList() =
        networkBoundResource(
            query = {
                deliveryMappers.desertMapper.mapFlow(deliveryDao.getAllDesert())
            },
            fetch = {
                delay(2000)
                apiService.getDelivery()
            },
            saveFetchResult = {

                deliveryDao.deleteAllDeserts()
                deliveryDao.insertDeserts(deliveryMappers.desertMapper.mapResponseToList(it))
            }
        )


    override fun getComboList() =
        networkBoundResource(
            query = {
                deliveryMappers.comboMapper.mapFlow(deliveryDao.getAllCombo())
            },
            fetch = {
                delay(2000)
                apiService.getDelivery()
            },
            saveFetchResult = {

                deliveryDao.deleteAllCombos()
                deliveryDao.insertCombos(deliveryMappers.comboMapper.mapResponseToList(it))
            }
        )



    override fun getPizzaInfo(id: Int): PizzaModel {
        return deliveryMappers.pizzaMapper.mapFromEntity(deliveryDao.getPizzaInfo(id))
    }

    override fun getDrinkInfo(id: Int): DrinkModel {
        return deliveryMappers.drinkMapper.mapFromEntity(deliveryDao.getDrinkInfo(id))
    }

    override fun getComboInfo(id: Int): ComboModel {
        return deliveryMappers.comboMapper.mapFromEntity(deliveryDao.getComboInfo(id))
    }

    override fun getDesertInfo(id: Int): DesertModel {
        return deliveryMappers.desertMapper.mapFromEntity(deliveryDao.getDesertInfo(id))
    }


}