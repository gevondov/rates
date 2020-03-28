package com.gevondov.rates.presentation.banks

import android.util.Log
import com.gevondov.rates.R
import com.gevondov.rates.presentation.base.BasePresenter
import com.gevondov.rates.presentation.common.adapter.RateListItem

class BanksPresenter(
    private val model: BanksContract.Model
) : BasePresenter<BanksContract.View>(), BanksContract.Presenter {

    companion object {
        const val TAG = "BanksPresenter"
    }

    override fun bind(view: BanksContract.View) {
        super.bind(view)

        addDisposable(view.bankItemClicks
            .subscribe(this::onBankItemClick, this::onBankItemCLickError))

        addDisposable(model.getBanks()
            .map { list -> list.map { RateListItem(it.id, R.drawable.ic_bank, it.name, it.rates.first().buy, it.rates.first().sell) } }
            .subscribe(view::updateItems, Throwable::printStackTrace))
    }

    private fun onBankItemClick(id: String) {
        view?.navigateToBank(id)
    }

    private fun onBankItemCLickError(throwable: Throwable) {
        Log.e(TAG, "onBankItemCLickError", throwable)
    }

}
