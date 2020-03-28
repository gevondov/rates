package com.gevondov.rates.presentation.banks

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.presentation.base.BaseContract
import io.reactivex.Observable

class BanksContract {

    interface Model : BaseContract.Model {

        fun getBanks(): List<Bank>

    }

    interface View : BaseContract.View {

        val bankItemClicks: Observable<String>

        fun navigateToBank(id: String)

    }

    interface Presenter : BaseContract.Presenter<View>

}
