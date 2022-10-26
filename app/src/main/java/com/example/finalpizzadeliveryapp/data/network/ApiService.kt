package com.example.finalpizzadeliveryapp.data.network

import com.example.finalpizzadeliveryapp.data.network.entity.DeliveryResponse
import com.example.finalpizzadeliveryapp.utils.Const.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(API_KEY)
    suspend fun getDelivery(): Response<DeliveryResponse>



}