package com.gevondov.rates.presentation.bank

import com.gevondov.rates.presentation.base.BasePresenter

class BankPresenter(
    private val model: BankContract.Model
) : BasePresenter<BankContract.View>(), BankContract.Presenter
