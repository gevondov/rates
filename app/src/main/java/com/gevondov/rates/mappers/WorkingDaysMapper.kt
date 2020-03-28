package com.gevondov.rates.mappers

import com.gevondov.rates.data.memory.entities.WorkingDayEntity
import com.gevondov.rates.data.remote.response.WorkingDayResponse
import com.gevondov.rates.domain.model.WorkingDay

class WorkingDaysMapper {

    fun fromResponse(response: WorkingDayResponse) = WorkingDayEntity(
        days = response.days,
        hours = response.hours
    )

    fun fromResponses(responses: List<WorkingDayResponse>) = responses.map(this::fromResponse)

    fun fromEntity(entity: WorkingDayEntity): WorkingDay {
        val days = extractDays(entity.days)
        return WorkingDay(
            startDay = days.first,
            endDay = days.second,
            hours = entity.hours
        )
    }

    fun fromEntities(entities: List<WorkingDayEntity>) = entities.map(this::fromEntity)

    private fun extractDays(days: String): Pair<Int, Int> {
        val split = days.split('-')
        val startDate = split.first().toInt() - 1
        val endDate = split.getOrElse(1) { split.first() }.toInt() - 1
        return Pair(startDate, endDate)
    }

}
