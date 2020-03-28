package com.gevondov.rates.presentation.banks

import android.util.Log
import com.gevondov.rates.R
import com.gevondov.rates.mappers.RateListItemMapper
import com.gevondov.rates.presentation.base.BasePresenter
import com.gevondov.rates.presentation.common.adapter.header.RateHeaderListItem
import io.reactivex.android.schedulers.AndroidSchedulers

class BanksPresenter(
    private val model: BanksContract.Model,
    private val rateListItemMapper: RateListItemMapper
) : BasePresenter<BanksContract.View>(), BanksContract.Presenter {

    companion object {
        const val TAG = "BanksPresenter"
    }

    override fun bind(view: BanksContract.View) {
        super.bind(view)

        addDisposable(view.bankItemClicks
            .subscribe(this::onBankItemClick, this::onBankItemCLickError))

        addDisposable(model.refreshBanks()
            .subscribe({}, Throwable::printStackTrace))

        addDisposable(model.observeBanksChanges()
            .subscribe({ loadCurrencies() }, Throwable::printStackTrace))
    }

    private fun loadCurrencies() {
        addDisposable(model.getCurrencies()
            .subscribe(this::onCurrenciesNext, Throwable::printStackTrace))
    }

    private fun onCurrenciesNext(currencies: List<String>) {
        view?.showCurrencies(currencies)
        loadBanks(currencies.first())
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

    private fun onBankItemCLickError(throwable: Throwable) {
        Log.e(TAG, "onBankItemCLickError", throwable)
    }

}
