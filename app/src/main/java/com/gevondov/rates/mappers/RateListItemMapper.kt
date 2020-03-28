package com.gevondov.rates.mappers

import com.gevondov.rates.R
import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.presentation.common.adapter.RateListItem

class RateListItemMapper {

    fun fromBanks(banks: List<Bank>) = banks.map { bank ->
        RateListItem(
            id = bank.id,
            icon = R.drawable.ic_bank,
            name = bank.name,
            buyRate = bank.rates.first().buy,
            sellRate = bank.rates.first().sell
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
