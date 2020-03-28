package com.gevondov.rates.presentation.bank

import com.gevondov.rates.presentation.base.BaseContract

interface BankContract {

    interface Model : BaseContract.Model

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
