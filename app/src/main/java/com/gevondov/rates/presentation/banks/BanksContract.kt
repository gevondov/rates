package com.gevondov.rates.presentation.banks

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.presentation.base.BaseContract

class BanksContract {

    interface Model : BaseContract.Model {

        fun getBanks(): List<Bank>

    }

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View>

}
