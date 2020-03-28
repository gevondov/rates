package com.gevondov.rates.mappers

import com.gevondov.rates.data.memory.entities.BankEntity
import com.gevondov.rates.data.remote.response.BankResponse
import com.gevondov.rates.domain.model.Bank

class BankMapper(
    private val rateMapper: RateMapper
) {

    fun fromResponse(response: BankResponse) = BankEntity(
        id = response.id,
        name = response.name,
        rates = rateMapper.fromResponses(response.rates)
    )

    fun fromResponses(responses: List<BankResponse>) = responses.map(this::fromResponse)

    fun fromEntity(entity: BankEntity) = Bank(
        id = entity.id,
        name = entity.name,
        rates = rateMapper.fromEntities(entity.rates)
    )

    fun fromEntities(entities: List<BankEntity>) = entities.map(this::fromEntity)

}
