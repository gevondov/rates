package com.gevondov.rates.presentation.banks

import com.gevondov.rates.data.observer.RateDataObserver
import com.gevondov.rates.domain.RatesInteractor

class BanksModel(
    private val ratesInteractor: RatesInteractor,
    private val rateDataObserver: RateDataObserver
) : BanksContract.Model {

    override fun observeBanksChanges() = rateDataObserver.observeBanksChanges()

    override fun refreshBanks() = ratesInteractor.refreshBanks()

    override fun getCurrencies() = ratesInteractor.getCurrencies()

    override fun getBanks(currency: String) = ratesInteractor.getBanks(currency)

}
