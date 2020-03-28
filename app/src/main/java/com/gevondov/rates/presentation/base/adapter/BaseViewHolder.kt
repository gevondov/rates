package com.gevondov.rates.presentation.base.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding3.view.clicks

abstract class BaseViewHolder<I : BaseListItem>(
    itemView: View
) : RecyclerView.ViewHolder(
    itemView
) {

    fun clicks() = itemView.clicks()

    abstract fun onBind(item: I)

}
