package com.gevondov.rates.presentation.banks

import com.gevondov.rates.presentation.banks.adapter.BankListItem
import com.gevondov.rates.presentation.base.BasePresenter

class BanksPresenter(
    private val model: BanksContract.Model
) : BasePresenter<BanksContract.View>(), BanksContract.Presenter {

    override fun bind(view: BanksContract.View) {
        super.bind(view)

        val banks = model.getBanks()
            .map { BankListItem(it.name, it.rates.first().buy, it.rates.first().sell) }
        view.updateItems(banks)
    }

}
