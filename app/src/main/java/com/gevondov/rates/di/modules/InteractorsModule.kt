package com.gevondov.rates.di.modules

import com.gevondov.rates.domain.RatesInteractor
import com.gevondov.rates.domain.RatesInteractorImpl
import org.koin.dsl.module

val INTERACTORS_MODULE = module {

    single<RatesInteractor> { RatesInteractorImpl() }

}
