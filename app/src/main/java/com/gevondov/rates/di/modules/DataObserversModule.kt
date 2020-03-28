package com.gevondov.rates.di.modules

import com.gevondov.rates.data.observer.RateDataEmitter
import com.gevondov.rates.data.observer.RateDataObserver
import com.gevondov.rates.data.observer.RateDataObserverImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val DATA_OBSERVERS_MODULE = module {

    single<RateDataObserver> { RateDataObserverImpl() } bind RateDataEmitter::class

}
