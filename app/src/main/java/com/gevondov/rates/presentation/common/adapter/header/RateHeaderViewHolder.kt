package com.gevondov.rates.presentation.common.adapter.header

import android.view.View
import android.widget.TextView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder

class RateHeaderViewHolder(
    itemView: View
) : BaseViewHolder<RateHeaderListItem>(
    itemView
) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)

    override fun onBind(item: RateHeaderListItem) {
        nameView.setText(item.title)
    }

}
