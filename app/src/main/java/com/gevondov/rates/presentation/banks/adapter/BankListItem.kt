package com.gevondov.rates.presentation.banks.adapter

import com.gevondov.rates.presentation.base.adapter.BaseListItem

data class BankListItem(
    override val id: String,
    val name: String,
    val buyRate: Float,
    val sellRate: Float
) : BaseListItem
