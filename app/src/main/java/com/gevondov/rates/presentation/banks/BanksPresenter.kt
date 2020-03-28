package com.gevondov.rates.presentation.banks

import android.util.Log
import com.gevondov.rates.mappers.RateListItemMapper
import com.gevondov.rates.presentation.base.BasePresenter
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

        loadBanks(view)

        addDisposable(model.refreshBanks()
            .subscribe({}, Throwable::printStackTrace))

        addDisposable(model.observeBanksChanges()
            .subscribe({ loadBanks(view) }, Throwable::printStackTrace))
    }

    private fun loadBanks(view: BanksContract.View) {
        addDisposable(model.getBanks()
                .map(rateListItemMapper::fromBanks)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::updateItems, Throwable::printStackTrace))
    }

    private fun onBankItemClick(id: String) {
        view?.navigateToBank(id)
    }

    private fun onBankItemCLickError(throwable: Throwable) {
        Log.e(TAG, "onBankItemCLickError", throwable)
    }

}
