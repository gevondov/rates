package com.gevondov.rates.presentation.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<I : BaseListItem>(
    itemView: View
) : RecyclerView.ViewHolder(
    itemView
) {

    abstract fun onBind(item: I)

}
