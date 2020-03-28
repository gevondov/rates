package com.gevondov.rates.presentation.bank.adapter.header

import com.gevondov.rates.presentation.base.adapter.BaseListItem

data class BankHeaderListItem(
    override val id: String,
    val name: String,
    val branchName: String,
    val address: String,
    val phone: String,
    val workingDays: List<WorkingDay>
) : BaseListItem {

    data class WorkingDay(
        val days: String,
        val hours: String
    )

}
