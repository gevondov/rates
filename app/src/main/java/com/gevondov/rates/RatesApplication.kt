package com.gevondov.rates

import android.app.Application
import com.gevondov.rates.di.modules.MODELS_MODULE
import com.gevondov.rates.di.modules.PRESENTERS_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RatesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@RatesApplication)
            modules(
                PRESENTERS_MODULE,
                MODELS_MODULE
            )
        }
    }

}
