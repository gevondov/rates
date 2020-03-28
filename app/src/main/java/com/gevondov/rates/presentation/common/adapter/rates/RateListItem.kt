package com.gevondov.rates.presentation.common.adapter.rates

import androidx.annotation.DrawableRes
import com.gevondov.rates.presentation.base.adapter.BaseListItem

data class RateListItem(
    override val id: String,
    @DrawableRes val icon: Int,
    val name: String,
    val buyRate: Float,
    val sellRate: Float
) : BaseListItem
