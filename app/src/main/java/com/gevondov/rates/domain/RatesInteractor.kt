package com.gevondov.rates.domain

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.domain.model.Branch
import io.reactivex.Single

interface RatesInteractor {

    fun getBanks(): Single<List<Bank>>

    fun getBranch(id: String): Single<Branch>

}
