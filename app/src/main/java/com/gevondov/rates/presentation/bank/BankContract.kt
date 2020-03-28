package com.gevondov.rates.presentation.bank

import com.gevondov.rates.domain.model.Branch
import com.gevondov.rates.presentation.base.BaseContract
import io.reactivex.Completable
import io.reactivex.Single

interface BankContract {

    interface Model : BaseContract.Model {

        fun refreshBranch(bankId: String): Completable

        fun getBranch(bankId: String): Single<Branch>

    }

    interface View : BaseContract.View

    interface Presenter : BaseContract.Presenter<View> {

        var bankId: String

    }
}
