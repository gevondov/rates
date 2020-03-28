package com.gevondov.rates.mappers

import com.gevondov.rates.R
import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.presentation.common.adapter.rates.RateListItem

class RateListItemMapper {

    fun fromBanks(banks: List<Bank>, currency: String) = banks.map { bank ->
        RateListItem(
            id = bank.id,
            icon = R.drawable.ic_bank,
            name = bank.name,
            buyRate = bank.rates.find { it.name == currency }?.buy ?: 0F,
            sellRate = bank.rates.find { it.name == currency }?.sell ?: 0F
        )
    }

    fun fromBank(bank: Bank) = bank.rates.map { rate ->
        RateListItem(
            id = rate.name,
            icon = R.drawable.ic_currency,
            name = rate.name,
            buyRate = rate.buy,
            sellRate = rate.sell
        )
    }

}
