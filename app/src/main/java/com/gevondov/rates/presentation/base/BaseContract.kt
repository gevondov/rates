package com.gevondov.rates.presentation.base

import com.gevondov.rates.presentation.base.adapter.BaseListItem

interface BaseContract {

    interface View {

        fun updateItems(newItems: List<BaseListItem>)

    }

}
