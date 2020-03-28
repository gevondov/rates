package com.gevondov.rates.domain

import com.gevondov.rates.data.repository.RatesRepository

class RatesInteractorImpl(
    private val ratesRepository: RatesRepository
) : RatesInteractor {

    override fun refreshBanks() = ratesRepository.refreshBanks()

    override fun refreshBranch(bankId: String) = ratesRepository.refreshBranch(bankId)

    override fun getBanks() = ratesRepository.getBanks()

    override fun getBranch(bankId: String) = ratesRepository.getBranch(bankId)

}
