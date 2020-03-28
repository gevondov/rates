package com.gevondov.rates.presentation.bank

import com.gevondov.rates.domain.RatesInteractor

class BankModel(
    private val ratesInteractor: RatesInteractor
) : BankContract.Model {

    override fun refreshBranch(bankId: String) = ratesInteractor.refreshBranch(bankId)

    override fun getBranch(bankId: String) = ratesInteractor.getBranch(bankId)

}
