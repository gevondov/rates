package com.gevondov.rates.presentation.common.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder

class RateViewHolder(
    itemView: View
) : BaseViewHolder<RateListItem>(
    itemView
) {

    private val iconView = itemView.findViewById<ImageView>(R.id.icon)
    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val buyRateView = itemView.findViewById<TextView>(R.id.buy_rate)
    private val sellRateView = itemView.findViewById<TextView>(R.id.sell_rate)

    override fun onBind(item: RateListItem) {
        iconView.setImageResource(item.icon)
        nameView.text = item.name
        buyRateView.text = item.buyRate.toString()
        sellRateView.text = item.sellRate.toString()
    }

}
