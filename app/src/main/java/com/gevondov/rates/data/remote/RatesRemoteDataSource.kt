package com.gevondov.rates.data.remote

import com.gevondov.rates.data.remote.response.BankResponse
import com.gevondov.rates.data.remote.response.BranchResponse
import io.reactivex.Single

interface RatesRemoteDataSource {

    fun getBanks(): Single<List<BankResponse>>

    fun getBranches(bankId: String): Single<List<BranchResponse>>

}
