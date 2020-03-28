package com.gevondov.rates.presentation.bank

import com.gevondov.rates.domain.model.Branch
import com.gevondov.rates.presentation.base.BaseContract

interface BankContract {

    interface Model : BaseContract.Model {

        fun getBranch(): Branch

    }

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>
}
