package com.gevondov.rates.presentation.banks

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.presentation.base.BaseContract
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

class BanksContract {

    interface Model : BaseContract.Model {

        fun observeBanksChanges(): Observable<Unit>

        fun refreshBanks(): Completable

        fun getCurrencies(): Single<List<String>>

        fun getBanks(currency: String): Single<List<Bank>>

    }

    interface View : BaseContract.View {

        val bankItemClicks: Observable<String>

        val currencySelectorClicks: Observable<Unit>

        fun navigateToBank(id: String)

        fun showCurrency(currency: String)

        fun showCurrencies(currencies: List<String>, currentCurrency: String)

    }

    interface Presenter : BaseContract.Presenter<View> {

        fun onCurrencySelected(currency: String)

    }

}
