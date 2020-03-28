package com.gevondov.rates.presentation.banks

import com.gevondov.rates.domain.RatesInteractor

class BanksModel(
    private val ratesInteractor: RatesInteractor
) : BanksContract.Model {

    override fun refreshBanks() = ratesInteractor.refreshBanks()

    override fun getBanks() = ratesInteractor.getBanks()

}
