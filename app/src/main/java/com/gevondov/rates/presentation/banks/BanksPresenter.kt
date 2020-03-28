package com.gevondov.rates.presentation.banks

import com.gevondov.rates.R
import com.gevondov.rates.mappers.RateListItemMapper
import com.gevondov.rates.presentation.base.BasePresenter
import com.gevondov.rates.presentation.common.adapter.header.RateHeaderListItem
import io.reactivex.android.schedulers.AndroidSchedulers

class BanksPresenter(
    private val model: BanksContract.Model,
    private val rateListItemMapper: RateListItemMapper
) : BasePresenter<BanksContract.View>(), BanksContract.Presenter {

    private var currentCurrency: String? = null

    override fun bind(view: BanksContract.View) {
        super.bind(view)

        addDisposable(view.bankItemClicks
            .subscribe(this::onBankItemClick, Throwable::printStackTrace))

        addDisposable(view.currencySelectorClicks
            .subscribe(this::onCurrencySelectorClick, Throwable::printStackTrace))

        addDisposable(model.refreshBanks()
            .subscribe({}, Throwable::printStackTrace))

        addDisposable(model.observeBanksChanges()
            .subscribe(this::onObserveBanksNext, Throwable::printStackTrace))
    }

    private fun onObserveBanksNext(ignore: Unit) {
        if (currentCurrency == null) {
            loadCurrentCurrency()
        } else {
            view?.showCurrency(currentCurrency!!)
            loadBanks(currentCurrency!!)
        }
    }

    private fun loadCurrentCurrency() {
        addDisposable(model.getCurrencies()
            .subscribe({ onCurrencySelected(it.first()) }, Throwable::printStackTrace))
    }

    private fun loadBanks(currency: String) {
        addDisposable(model.getBanks(currency)
            .map { rateListItemMapper.fromBanks(it, currency) }
            .map { listOf(RateHeaderListItem(title = R.string.bank)) + it }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ view?.updateItems(it) }, Throwable::printStackTrace))
    }

    private fun onBankItemClick(id: String) {
        view?.navigateToBank(id)
    }

    private fun onCurrencySelectorClick(ignore: Unit) {
        addDisposable(model.getCurrencies()
            .subscribe({ view?.showCurrencies(it, currentCurrency!!) }, Throwable::printStackTrace))
    }

    override fun onCurrencySelected(currency: String) {
        currentCurrency = currency
        view?.showCurrency(currency)
        loadBanks(currency)
    }

}
