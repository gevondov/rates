package com.gevondov.rates.presentation.bank

import com.gevondov.rates.data.observer.RateDataObserver
import com.gevondov.rates.domain.RatesInteractor

class BankModel(
    private val ratesInteractor: RatesInteractor,
    private val rateDataObserver: RateDataObserver
) : BankContract.Model {

    override fun observeBranchChanges() = rateDataObserver.observeBranchChanges()

    override fun refreshBranch(bankId: String) = ratesInteractor.refreshBranch(bankId)

    override fun getBranch(bankId: String) = ratesInteractor.getBranch(bankId)

}
