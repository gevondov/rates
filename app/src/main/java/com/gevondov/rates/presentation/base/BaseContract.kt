package com.gevondov.rates.presentation.base

import com.gevondov.rates.presentation.base.adapter.BaseListItem

interface BaseContract {

    interface Model

    interface View {

        fun updateItems(newItems: List<BaseListItem>)

    }

    interface Presenter<V : View> {

        fun bind(view: V)

        fun unBind()

    }

}
