package com.gevondov.rates.presentation.banks

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.presentation.base.BaseContract
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class BanksContract {

    interface Model : BaseContract.Model {

        fun refreshBanks(): Completable

        fun getBanks(): Single<List<Bank>>

    }

    interface View : BaseContract.View {

        val bankItemClicks: Observable<String>

        fun navigateToBank(id: String)

    }

    interface Presenter : BaseContract.Presenter<View>

}
