package com.gevondov.rates.presentation.bank

import com.gevondov.rates.domain.RatesInteractor

class BankModel(
    private val ratesInteractor: RatesInteractor
) : BankContract.Model {

    override fun getBranch(id: String) = ratesInteractor.getBranch(id)

}
