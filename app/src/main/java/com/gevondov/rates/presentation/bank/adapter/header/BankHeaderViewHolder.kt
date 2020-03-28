package com.gevondov.rates.presentation.bank.adapter.header

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.get
import com.gevondov.rates.R
import com.gevondov.rates.extensions.inflate
import com.gevondov.rates.presentation.base.adapter.BaseViewHolder

class BankHeaderViewHolder(
    itemView: View
) : BaseViewHolder<BankHeaderListItem>(
    itemView
) {

    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private val branchNameView = itemView.findViewById<TextView>(R.id.branch_name)
    private val addressView = itemView.findViewById<TextView>(R.id.address)
    private val phoneView = itemView.findViewById<TextView>(R.id.phone)
    private val workingDaysContainer = itemView.findViewById<ViewGroup>(R.id.working_days_container)

    override fun onBind(item: BankHeaderListItem) {
        nameView.text = item.name
        branchNameView.text = item.branchName
        addressView.text = item.address
        phoneView.text = item.phone
        inflateWorkingDays(item.workingDays)
    }

    private fun inflateWorkingDays(workingDays: List<BankHeaderListItem.WorkingDay>) {
        normalizeChildrenCount(workingDays.size)
        workingDays.forEachIndexed { index, workingDay ->
            val workingDayView = workingDaysContainer[index]
            val daysView = workingDayView.findViewById<TextView>(R.id.days)
            val hoursView = workingDayView.findViewById<TextView>(R.id.hours)
            daysView.text = workingDay.days
            hoursView.text = workingDay.hours
        }
    }

    private fun normalizeChildrenCount(count: Int) {
        if (workingDaysContainer.childCount == count) {
            return
        }
        if (workingDaysContainer.childCount < count) {
            (workingDaysContainer.childCount until count).forEach {
                val workingDay = workingDaysContainer.inflate(R.layout.view_working_day)
                workingDaysContainer.addView(workingDay, it)
            }
        } else {
            (count until workingDaysContainer.childCount).forEach {
                workingDaysContainer.removeViewAt(it)
            }
        }
    }

}
