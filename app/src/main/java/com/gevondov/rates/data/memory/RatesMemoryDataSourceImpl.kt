package com.gevondov.rates.data.memory

import com.gevondov.rates.data.memory.entities.BankEntity
import com.gevondov.rates.data.memory.entities.BranchEntity
import com.gevondov.rates.data.observer.RateDataEmitter
import io.reactivex.Completable
import io.reactivex.Single

class RatesMemoryDataSourceImpl(
    private val rateDataEmitter: RateDataEmitter
) : RatesMemoryDataSource {

    private val banks = mutableListOf<BankEntity>()
    private val bankIdToBranches = mutableMapOf<String, List<BranchEntity>>()

    override fun saveBanks(banks: List<BankEntity>) = Completable.fromAction {
        this.banks.clear()
        this.banks.addAll(banks)
        rateDataEmitter.emitBanksChanges()
    }

    override fun saveBranches(bankId: String, branches: List<BranchEntity>) = Completable.fromAction {
        bankIdToBranches[bankId] = branches
        rateDataEmitter.emitBranchChanges()
    }

    override fun getCurrencies() =
        Single.just(banks.flatMap { it.rates }.map { it.name }.distinct())

    override fun getBank(bankId: String) =
        Single.just(banks.first { it.id == bankId })

    override fun getBanks(currency: String) =
        Single.just(banks.filter { it.rates.any { rate -> rate.name == currency } })

    override fun getBranch(bankId: String): Single<BranchEntity> {
        val branches = bankIdToBranches[bankId] ?: emptyList()
        val headBranch = branches.find { it.isHead } ?: branches.firstOrNull()
        return headBranch?.let { Single.just(it) } ?: Single.never()
    }

}
