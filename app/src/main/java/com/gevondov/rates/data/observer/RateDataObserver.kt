package com.gevondov.rates.data.observer

import io.reactivex.Observable

interface RateDataObserver {

    fun observeBanksChanges(): Observable<Unit>

    fun observeBranchChanges(): Observable<Unit>

}
