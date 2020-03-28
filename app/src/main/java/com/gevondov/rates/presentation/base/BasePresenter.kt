package com.gevondov.rates.presentation.base

import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    protected var view: V? = null
        private set

    private val disposables = CompositeDisposable()

    override fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    @CallSuper
    override fun bind(view: V) {
        this.view = view
    }

    @CallSuper
    override fun unBind() {
        view = null
        disposables.clear()
    }

}
