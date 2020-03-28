package com.gevondov.rates.mappers

import com.gevondov.rates.data.memory.entities.RateEntity
import com.gevondov.rates.data.remote.response.RateResponse
import com.gevondov.rates.domain.model.Rate

class RateMapper {

    fun fromResponse(response: RateResponse) = RateEntity(
        name = response.name,
        buy = response.buy,
        sell = response.sell
    )

    fun fromResponses(responses: List<RateResponse>) = responses.map(this::fromResponse)

    fun fromEntity(entity: RateEntity) = Rate(
        name = entity.name,
        buy = entity.buy,
        sell = entity.sell
    )

    fun fromEntities(entities: List<RateEntity>) = entities.map(this::fromEntity)

}
