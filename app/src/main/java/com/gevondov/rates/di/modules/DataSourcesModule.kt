package com.gevondov.rates.di.modules

import com.gevondov.rates.data.memory.RatesMemoryDataSource
import com.gevondov.rates.data.memory.RatesMemoryDataSourceImpl
import com.gevondov.rates.data.remote.RatesRemoteDataSource
import com.gevondov.rates.data.remote.RatesRemoteDataSourceImpl
import org.koin.dsl.module

val DATA_SOURCES_MODULE = module {

    single<RatesRemoteDataSource> { RatesRemoteDataSourceImpl(get()) }

    single<RatesMemoryDataSource> { RatesMemoryDataSourceImpl(get()) }

}
