package com.gevondov.rates.presentation.bank.adapter

import android.view.ViewGroup
import com.gevondov.rates.R
import com.gevondov.rates.extensions.inflate
import com.gevondov.rates.presentation.bank.adapter.header.BankHeaderListItem
import com.gevondov.rates.presentation.bank.adapter.header.BankHeaderViewHolder
import com.gevondov.rates.presentation.base.adapter.BaseAdapter
import com.gevondov.rates.presentation.base.adapter.BaseListItem
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder
import com.gevondov.rates.presentation.common.adapter.rates.RateListItem
import com.gevondov.rates.presentation.common.adapter.rates.RateViewHolder

class BankAdapter : BaseAdapter() {

    companion object {
        private const val VIEW_TYPE_HEADER = 1
        private const val VIEW_TYPE_RATE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (val item = items[position]) {
            is BankHeaderListItem -> VIEW_TYPE_HEADER
            is RateListItem -> VIEW_TYPE_RATE
            else -> throw IllegalStateException("Incorrect item type: ${item.javaClass.name}")
        }
    }

    override fun createHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseListItem> {
        return when (viewType) {
            VIEW_TYPE_HEADER -> BankHeaderViewHolder(parent.inflate(R.layout.list_item_bank_header))
            VIEW_TYPE_RATE -> RateViewHolder(
                parent.inflate(R.layout.list_item_rate)
            )
            else -> throw IllegalStateException("Incorrect view type: $viewType")
        }
    }

}
