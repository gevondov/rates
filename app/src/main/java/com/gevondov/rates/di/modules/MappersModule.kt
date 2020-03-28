package com.gevondov.rates.di.modules

import com.gevondov.rates.mappers.*
import org.koin.dsl.module

val MAPPERS_MODULE = module {

    single { RateListItemMapper() }

    single { BankHeaderListItemMapper() }

    single { BankMapper(get()) }

    single { BranchMapper(get(), get()) }

    single { RateMapper() }

    single { WorkingDaysMapper() }

}
