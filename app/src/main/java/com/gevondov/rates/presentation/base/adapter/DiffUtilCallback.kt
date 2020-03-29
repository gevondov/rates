package com.gevondov.rates.presentation.base.adapter

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback(
    private val oldList: List<BaseListItem>,
    private val newList: List<BaseListItem>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(old: Int, new: Int) = oldList[old].id == newList[new].id

    override fun areContentsTheSame(old: Int, new: Int) = oldList[old] == newList[new]

}
