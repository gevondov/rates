package com.gevondov.rates.data.memory

import com.gevondov.rates.data.memory.entities.BankEntity
import com.gevondov.rates.data.memory.entities.BranchEntity
import io.reactivex.Completable
import io.reactivex.Single

interface RatesMemoryDataSource {

    fun saveBanks(banks: List<BankEntity>): Completable

    fun saveBranches(bankId: String, branches: List<BranchEntity>): Completable

    fun getBank(bankId: String): Single<BankEntity>

    fun getBanks(): Single<List<BankEntity>>

    fun getBranch(bankId: String): Single<BranchEntity>

}
