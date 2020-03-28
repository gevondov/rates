package com.gevondov.rates.di.modules

import com.gevondov.rates.presentation.bank.BankContract
import com.gevondov.rates.presentation.bank.adapter.BankModel
import com.gevondov.rates.presentation.banks.BanksContract
import com.gevondov.rates.presentation.banks.BanksModel
import org.koin.dsl.module

val MODELS_MODULE = module {

    factory<BanksContract.Model> { BanksModel() }

    factory<BankContract.Model> { BankModel() }

}
