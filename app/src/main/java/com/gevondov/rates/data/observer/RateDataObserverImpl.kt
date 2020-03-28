package com.gevondov.rates.data.observer

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

class RateDataObserverImpl : RateDataObserver, RateDataEmitter {

    private val bankChangesSubject: PublishSubject<Unit> = PublishSubject.create()
    private val branchChangesSubject: PublishSubject<Unit> = PublishSubject.create()

    override fun observeBanksChanges(): Observable<Unit> = bankChangesSubject

    override fun observeBranchChanges(): Observable<Unit> = branchChangesSubject

    override fun emitBanksChanges() {
        bankChangesSubject.onNext(Unit)
    }

    override fun emitBranchChanges() {
        branchChangesSubject.onNext(Unit)
    }

}
