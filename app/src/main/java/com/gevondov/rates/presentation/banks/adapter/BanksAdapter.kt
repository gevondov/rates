package com.gevondov.rates.presentation.banks.adapter

import android.view.ViewGroup
import com.gevondov.rates.R
import com.gevondov.rates.extensions.inflate
import com.gevondov.rates.presentation.base.adapter.BaseAdapter
import com.gevondov.rates.presentation.base.adapter.BaseListItem
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder
import com.gevondov.rates.presentation.common.adapter.rates.RateViewHolder

class BanksAdapter : BaseAdapter() {

    override fun createHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseListItem> {
        return RateViewHolder(
            parent.inflate(R.layout.list_item_rate)
        )
    }

}
