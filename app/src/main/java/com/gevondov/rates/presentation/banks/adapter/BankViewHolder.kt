package com.gevondov.rates.presentation.banks.adapter

import android.view.View
import android.widget.TextView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder

class BankViewHolder(
    itemView: View
) : BaseViewHolder<BankListItem>(
    itemView
) {

    private val bankNameView = itemView.findViewById<TextView>(R.id.name)
    private val buyRateView = itemView.findViewById<TextView>(R.id.buy_rate)
    private val sellRateView = itemView.findViewById<TextView>(R.id.sell_rate)

    override fun onBind(item: BankListItem) {
        bankNameView.text = item.name
        buyRateView.text = item.buyRate.toString()
        sellRateView.text = item.sellRate.toString()
    }

}
