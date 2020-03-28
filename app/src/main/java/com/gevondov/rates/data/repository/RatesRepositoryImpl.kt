package com.gevondov.rates.data.repository

import com.gevondov.rates.data.memory.RatesMemoryDataSource
import com.gevondov.rates.data.remote.RatesRemoteDataSource
import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.domain.model.Branch
import com.gevondov.rates.mappers.BankMapper
import com.gevondov.rates.mappers.BranchMapper
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles

class RatesRepositoryImpl(
    private val remoteDataSource: RatesRemoteDataSource,
    private val memoryDataSource: RatesMemoryDataSource,
    private val bankMapper: BankMapper,
    private val branchMapper: BranchMapper
) : RatesRepository {

    override fun refreshBanks(): Completable {
        return remoteDataSource.getBanks()
            .map { bankMapper.fromResponses(it) }
            .flatMapCompletable { memoryDataSource.saveBanks(it) }
    }

    override fun refreshBranch(bankId: String): Completable {
        return remoteDataSource.getBranches(bankId)
            .map { branchMapper.fromResponses(it) }
            .flatMapCompletable { memoryDataSource.saveBranches(bankId, it) }
    }

    override fun getCurrencies(): Single<List<String>> {
        return memoryDataSource.getCurrencies()
    }

    override fun getBanks(currency: String): Single<List<Bank>> {
        return memoryDataSource.getBanks(currency)
            .map(bankMapper::fromEntities)
    }

    override fun getBranch(bankId: String): Single<Branch> {
        return Singles.zip(
            memoryDataSource.getBranch(bankId),
            memoryDataSource.getBank(bankId),
            { branchEntity, bankEntity -> branchEntity to bankEntity }
        ).map { branchMapper.fromEntity(it.first, it.second) }
    }


}
