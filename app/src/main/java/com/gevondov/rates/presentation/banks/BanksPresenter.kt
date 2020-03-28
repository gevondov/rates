package com.gevondov.rates.presentation.banks

import android.util.Log
import com.gevondov.rates.presentation.banks.adapter.BankListItem
import com.gevondov.rates.presentation.base.BasePresenter

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

        val banks = model.getBanks()
            .map { BankListItem(it.id, it.name, it.rates.first().buy, it.rates.first().sell) }
        view.updateItems(banks)
    }

    private fun onBankItemClick(id: String) {
        view?.navigateToBank(id)
    }

    private fun onBankItemCLickError(throwable: Throwable) {
        Log.e(TAG, "onBankItemCLickError", throwable)
    }

}
