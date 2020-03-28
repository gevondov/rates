package com.gevondov.rates.presentation.common.adapter.header

import androidx.annotation.StringRes
import com.gevondov.rates.presentation.base.adapter.BaseListItem

data class RateHeaderListItem(
    override val id: String = "RateHeaderListItem",
    @StringRes val title: Int
) : BaseListItem
