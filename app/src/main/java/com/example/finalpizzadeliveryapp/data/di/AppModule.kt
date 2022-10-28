package com.example.finalpizzadeliveryapp.data.di

import android.content.Context
import androidx.room.Room
import com.example.finalpizzadeliveryapp.data.DeliveryRepositoryImpl
import com.example.finalpizzadeliveryapp.data.database.DeliveryDao
import com.example.finalpizzadeliveryapp.data.database.DeliveryDataBase
import com.example.finalpizzadeliveryapp.data.network.ApiService
import com.example.finalpizzadeliveryapp.data.network.mapper.*
import com.example.finalpizzadeliveryapp.domain.DeliveryRepository
import com.example.finalpizzadeliveryapp.domain.usecases.DeliveryUseCases
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetComboInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetDesertInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetDrinkInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.info.GetPizzaInfoUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetComboListUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetDesertListUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetDrinkListUseCase
import com.example.finalpizzadeliveryapp.domain.usecases.list.GetPizzaListUseCase
import com.example.finalpizzadeliveryapp.util.Const.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun baseUrl() = BASE_URL


    @Provides
    fun logging() = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun okHttpClient() = OkHttpClient.Builder()
        .addInterceptor(logging())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): ApiService =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient())
            .build()
            .create(ApiService::class.java)


    @Provides
    fun provideDeliveryDao(deliveryDataBase: DeliveryDataBase): DeliveryDao{
        return deliveryDataBase.getDeliveryDao()
    }

    @Provides
    @Singleton
    fun provideDeliveryDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            DeliveryDataBase::class.java,
            "delivery_database"
        ).build()




    @Provides
    @Singleton
    fun provideRepository(
        deliveryDao: DeliveryDao, apiService: ApiService,
        deliveryMappers: DeliveryMappers

        ): DeliveryRepository{
        return DeliveryRepositoryImpl(apiService, deliveryDao, deliveryMappers)
    }

    @Provides
    @Singleton
    fun provideDeliveryMapper(): DeliveryMappers {
        return DeliveryMappers(
            comboMapper = ComboMapper(),
            pizzaMapper = PizzaMapper(),
            drinkMapper = DrinkMapper(),
            desertMapper = DesertMapper()
        )
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: DeliveryRepository):DeliveryUseCases{
        return DeliveryUseCases(
            getPizzaListUseCase = GetPizzaListUseCase(repository),
            getComboInfoUseCase = GetComboInfoUseCase(repository),
            getPizzaInfoUseCase = GetPizzaInfoUseCase(repository),
            getDesertInfoUseCase = GetDesertInfoUseCase(repository),
            getDrinkInfoUseCase = GetDrinkInfoUseCase(repository),
            getComboListUseCase = GetComboListUseCase(repository),
            getDesertListUseCase = GetDesertListUseCase(repository),
            getDrinkListUseCase = GetDrinkListUseCase(repository)
        )
    }

}