package com.gevondov.rates.di.modules

import com.gevondov.rates.data.remote.network.RatesApi
import com.gevondov.rates.data.remote.network.deserializers.BanksResponseDeserializer
import com.gevondov.rates.data.remote.response.BanksResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://rate.am/ws/mobile/v2/"

val NETWORK_MODULE = module {

    single<Gson> {
        GsonBuilder()
            .registerTypeAdapter(BanksResponse::class.java, BanksResponseDeserializer())
            .create()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get<Gson>()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
            .build()
    }

    single<RatesApi> {
        get<Retrofit>().create(RatesApi::class.java)
    }

}