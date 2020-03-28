package com.gevondov.rates

import android.app.Application
import com.gevondov.rates.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RatesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RatesApplication)
            modules(
                MAPPERS_MODULE,
                PRESENTERS_MODULE,
                MODELS_MODULE,
                INTERACTORS_MODULE,
                REPOSITORIES_MODULE,
                DATA_SOURCES_MODULE,
                DATA_OBSERVERS_MODULE,
                NETWORK_MODULE
            )
        }
    }

}
