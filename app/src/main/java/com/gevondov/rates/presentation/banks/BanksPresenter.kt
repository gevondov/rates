package com.gevondov.rates.presentation.banks

import android.util.Log
import com.gevondov.rates.mappers.RateListItemMapper
import com.gevondov.rates.presentation.base.BasePresenter

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

        addDisposable(model.getBanks()
            .map(rateListItemMapper::fromBanks)
            .subscribe(view::updateItems, Throwable::printStackTrace))
    }

    private fun onBankItemClick(id: String) {
        view?.navigateToBank(id)
    }

    private fun onBankItemCLickError(throwable: Throwable) {
        Log.e(TAG, "onBankItemCLickError", throwable)
    }

}
