package com.gevondov.rates.presentation.banks

import com.gevondov.rates.presentation.banks.adapter.BankListItem
import com.gevondov.rates.presentation.base.BasePresenter

class BanksPresenter : BasePresenter<BanksContract.View>(), BanksContract.Presenter {

    override fun bind(view: BanksContract.View) {
        super.bind(view)

        view.updateItems(listOf(
            BankListItem("EvocaBank", 484.5F, 487F),
            BankListItem("UniBank", 484F, 487.5F),
            BankListItem("IdBank", 484.5F, 487.5F),
            BankListItem("InecoBank", 484.5F, 487.25F),
            BankListItem("AraratBank", 484F, 487F),
            BankListItem("HayEconomBank", 484.5F, 487.5F)
        ))
    }

}
