package com.gevondov.rates.data.remote.network

import com.gevondov.rates.data.remote.response.BanksResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RatesApi {

    @GET("rates.ashx?lang=en")
    fun getBanks(): Single<BanksResponse>

}
