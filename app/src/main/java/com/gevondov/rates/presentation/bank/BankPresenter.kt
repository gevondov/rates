package com.gevondov.rates.presentation.bank

import com.gevondov.rates.R
import com.gevondov.rates.domain.model.WorkingDay
import com.gevondov.rates.presentation.bank.adapter.header.BankHeaderListItem
import com.gevondov.rates.presentation.base.BasePresenter
import com.gevondov.rates.presentation.common.adapter.RateListItem

class BankPresenter(
    private val model: BankContract.Model
) : BasePresenter<BankContract.View>(), BankContract.Presenter {

    override fun bind(view: BankContract.View) {
        super.bind(view)

        val branch = model.getBranch()
        val bankHeaderItem = BankHeaderListItem(
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
        val rates = branch.bank.rates
            .map { RateListItem(it.name, R.drawable.ic_currency, it.name, it.buy, it.sell) }
        view.updateItems(listOf(bankHeaderItem) + rates)
    }

    private fun formatDays(workingDay: WorkingDay): String {
        return if (workingDay.startDay == workingDay.endDay) {
            getDay(workingDay.startDay)
        } else {
            "${getDay(workingDay.startDay)}-${getDay(workingDay.endDay)}"
        }
    }

    private fun getDay(index: Int): String {
        return when (index) {
            0 -> "Mon"
            1 -> "Tue"
            2 -> "Wed"
            3 -> "Thu"
            4 -> "Fri"
            5 -> "Sat"
            6 -> "Sun"
            else -> throw IllegalArgumentException("Day out of range: $index")
        }
    }

}
