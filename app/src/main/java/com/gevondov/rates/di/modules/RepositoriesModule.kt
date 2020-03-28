package com.gevondov.rates.di.modules

import com.gevondov.rates.data.repository.RatesRepository
import com.gevondov.rates.data.repository.RatesRepositoryImpl
import org.koin.dsl.module

val REPOSITORIES_MODULE = module {

    single<RatesRepository> { RatesRepositoryImpl(get(), get(), get(), get()) }

}
