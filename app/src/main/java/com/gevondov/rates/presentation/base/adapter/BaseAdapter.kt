package com.gevondov.rates.presentation.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder<BaseListItem>>() {

    private val items = mutableListOf<BaseListItem>()

    fun updateItems(newItems: List<BaseListItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<BaseListItem>, position: Int) {
        val item = items[position]
        holder.onBind(item)
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseListItem> {
        return createHolder(parent, viewType) as BaseViewHolder<BaseListItem>
    }

    abstract fun createHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseListItem>

}
