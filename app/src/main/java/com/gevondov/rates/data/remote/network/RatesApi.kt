package com.gevondov.rates.data.remote.network

import com.gevondov.rates.data.remote.response.BanksResponse
import com.gevondov.rates.data.remote.response.BranchesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesApi {

    @GET("rates.ashx?lang=en")
    fun getBanks(): Single<BanksResponse>

    @GET("branches.ashx")
    fun getBranches(@Query("id") bankId: String): Single<BranchesResponse>

}
