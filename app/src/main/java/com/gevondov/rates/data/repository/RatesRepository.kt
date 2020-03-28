package com.gevondov.rates.data.repository

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.domain.model.Branch
import io.reactivex.Completable
import io.reactivex.Single

interface RatesRepository {

    fun refreshBanks(): Completable

    fun refreshBranch(bankId: String): Completable

    fun getBanks(): Single<List<Bank>>

    fun getBranch(bankId: String): Single<Branch>

}