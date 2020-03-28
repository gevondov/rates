package com.gevondov.rates.mappers

import com.gevondov.rates.domain.model.Branch
import com.gevondov.rates.domain.model.WorkingDay
import com.gevondov.rates.presentation.bank.adapter.header.BankHeaderListItem

class BankHeaderListItemMapper {

    companion object {
        private val WEEKDAYS = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        private val WEEKDAYS_SHORT = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    }

    fun fromBranch(branch: Branch): BankHeaderListItem {
        return BankHeaderListItem(
            id = branch.id,
            name = branch.bank.name,
            branchName = branch.name,
            address = branch.address,
            phone = branch.phone,
            workingDays = branch.workingDays.map { BankHeaderListItem.WorkingDay(
                days = formatDays(it),
                hours = it.hours
            ) }
        )
    }

    private fun formatDays(workingDay: WorkingDay): String {
        return if (workingDay.startDay == workingDay.endDay) {
            WEEKDAYS[workingDay.startDay]
        } else {
            "${WEEKDAYS_SHORT[workingDay.startDay]}-${WEEKDAYS_SHORT[workingDay.endDay]}"
        }
    }

}
