package com.gevondov.rates.domain

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.domain.model.Branch
import io.reactivex.Completable
import io.reactivex.Single

interface RatesInteractor {

    fun refreshBanks(): Completable

    fun refreshBranch(bankId: String): Completable

    fun getCurrencies(): Single<List<String>>

    fun getBanks(currency: String): Single<List<Bank>>

    fun getBranch(bankId: String): Single<Branch>

}
