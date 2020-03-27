package com.gevondov.rates.presentation.base

import androidx.annotation.CallSuper

abstract class BasePresenter<V : BaseContract.View> : BaseContract.Presenter<V> {

    protected var view: V? = null
        private set

    @CallSuper
    override fun bind(view: V) {
        this.view = view
    }

    @CallSuper
    override fun unBind() {
        view = null
    }

}
