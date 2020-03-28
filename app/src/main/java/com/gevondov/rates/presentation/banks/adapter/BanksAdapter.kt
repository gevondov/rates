package com.gevondov.rates.presentation.banks.adapter

import android.view.ViewGroup
import com.gevondov.rates.R
import com.gevondov.rates.extensions.inflate
import com.gevondov.rates.presentation.base.adapter.BaseAdapter
import com.gevondov.rates.presentation.base.adapter.BaseListItem
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder
import com.gevondov.rates.presentation.common.adapter.header.RateHeaderListItem
import com.gevondov.rates.presentation.common.adapter.header.RateHeaderViewHolder
import com.gevondov.rates.presentation.common.adapter.rates.RateListItem
import com.gevondov.rates.presentation.common.adapter.rates.RateViewHolder

class BanksAdapter : BaseAdapter() {

    companion object {
        private const val VIEW_TYPE_RATE_HEADER = 1
        private const val VIEW_TYPE_RATE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = items[position]) {
            is RateHeaderListItem -> VIEW_TYPE_RATE_HEADER
            is RateListItem -> VIEW_TYPE_RATE
            else -> throw IllegalStateException("Incorrect item type: ${item.javaClass.name}")
        }
    }

    override fun createHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseListItem> {
        return when (viewType) {
            VIEW_TYPE_RATE_HEADER -> RateHeaderViewHolder(parent.inflate(R.layout.list_item_rate_header))
            VIEW_TYPE_RATE -> RateViewHolder(parent.inflate(R.layout.list_item_rate))
            else -> throw IllegalStateException("Incorrect view type: $viewType")
        }
    }

}
