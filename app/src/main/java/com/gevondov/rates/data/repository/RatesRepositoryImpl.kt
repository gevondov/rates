package com.gevondov.rates.data.repository

import com.gevondov.rates.data.memory.RatesMemoryDataSource
import com.gevondov.rates.data.remote.RatesRemoteDataSource
import com.gevondov.rates.mappers.BankMapper
import com.gevondov.rates.mappers.BranchMapper
import io.reactivex.rxkotlin.Singles

class RatesRepositoryImpl(
    private val remoteDataSource: RatesRemoteDataSource,
    private val memoryDataSource: RatesMemoryDataSource,
    private val bankMapper: BankMapper,
    private val branchMapper: BranchMapper
) : RatesRepository {

    override fun refreshBanks() = remoteDataSource.getBanks()
        .map { bankMapper.fromResponses(it) }
        .flatMapCompletable { memoryDataSource.saveBanks(it) }

    override fun refreshBranch(bankId: String) = remoteDataSource.getBranches(bankId)
        .map { branchMapper.fromResponses(it) }
        .flatMapCompletable { memoryDataSource.saveBranches(bankId, it) }

    override fun getCurrencies() = memoryDataSource.getCurrencies()

    override fun getBanks(currency: String) = memoryDataSource.getBanks(currency)
        .map(bankMapper::fromEntities)

    override fun getBranch(bankId: String) = Singles.zip(
        memoryDataSource.getBranch(bankId),
        memoryDataSource.getBank(bankId),
        { branchEntity, bankEntity -> branchEntity to bankEntity }
    ).map { branchMapper.fromEntity(it.first, it.second) }


}
