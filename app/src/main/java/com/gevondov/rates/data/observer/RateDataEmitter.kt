package com.gevondov.rates.data.observer

interface RateDataEmitter {

    fun emitBanksChanges()

    fun emitBranchChanges()

}
