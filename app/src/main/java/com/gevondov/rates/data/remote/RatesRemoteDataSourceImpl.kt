package com.gevondov.rates.data.remote

import com.gevondov.rates.data.remote.network.RatesApi

class RatesRemoteDataSourceImpl(
    private val ratesApi: RatesApi
) : RatesRemoteDataSource {

    override fun getBanks() = ratesApi.getBanks()
        .map { it.banks }

    override fun getBranches(bankId: String) = ratesApi.getBranches(bankId)
        .map { it.branches }

}
