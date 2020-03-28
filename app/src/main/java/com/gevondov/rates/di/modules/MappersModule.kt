package com.gevondov.rates.di.modules

import com.gevondov.rates.mappers.BankHeaderListItemMapper
import com.gevondov.rates.mappers.RateListItemMapper
import org.koin.dsl.module

val MAPPERS_MODULE = module {

    single { RateListItemMapper() }

    single { BankHeaderListItemMapper() }

}
