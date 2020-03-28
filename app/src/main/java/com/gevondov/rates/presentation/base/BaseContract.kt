package com.gevondov.rates.presentation.base

import com.gevondov.rates.presentation.base.adapter.BaseListItem
import io.reactivex.disposables.Disposable

interface BaseContract {

    interface Model

    interface View {

        fun updateItems(newItems: List<BaseListItem>)

    }

    interface Presenter<V : View> {

        fun bind(view: V)

        fun unBind()

        fun addDisposable(disposable: Disposable)

    }

}
