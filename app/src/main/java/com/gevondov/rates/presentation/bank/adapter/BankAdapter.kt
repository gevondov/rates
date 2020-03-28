package com.gevondov.rates.presentation.bank.adapter

import android.view.ViewGroup
import com.gevondov.rates.R
import com.gevondov.rates.extensions.inflate
import com.gevondov.rates.presentation.bank.adapter.header.BankHeaderViewHolder
import com.gevondov.rates.presentation.base.adapter.BaseAdapter
import com.gevondov.rates.presentation.base.adapter.BaseListItem
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder

class BankAdapter : BaseAdapter() {

    override fun createHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseListItem> {
        return BankHeaderViewHolder(parent.inflate(R.layout.list_item_bank_header))
    }

}
