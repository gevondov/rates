package com.gevondov.rates.di.modules

import com.gevondov.rates.presentation.bank.BankContract
import com.gevondov.rates.presentation.bank.BankPresenter
import com.gevondov.rates.presentation.banks.BanksContract
import com.gevondov.rates.presentation.banks.BanksPresenter
import org.koin.dsl.module

val PRESENTERS_MODULE = module {

    factory<BanksContract.Presenter> { BanksPresenter(get()) }

    factory<BankContract.Presenter> { BankPresenter(get()) }

}
