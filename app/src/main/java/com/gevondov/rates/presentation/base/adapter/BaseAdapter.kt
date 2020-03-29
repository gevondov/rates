package com.gevondov.rates.presentation.base.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder<BaseListItem>>() {

    private val clicks = PublishSubject.create<BaseListItem>()

    protected val items = mutableListOf<BaseListItem>()

    fun updateItems(newItems: List<BaseListItem>) {
        val diffCallback = DiffUtilCallback(items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    fun clicks(): Observable<BaseListItem> = clicks

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<BaseListItem>, position: Int) {
        val item = items[position]
        holder.onBind(item)
    }

    final override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseListItem> {
        val holder = createHolder(parent, viewType) as BaseViewHolder<BaseListItem>
        holder.clicks()
            .map { items[holder.adapterPosition] }
            .subscribe(clicks)
        return holder
    }

    abstract fun createHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<out BaseListItem>

}
