package com.gevondov.rates.presentation.bank

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.domain.model.Branch
import com.gevondov.rates.domain.model.Rate
import com.gevondov.rates.domain.model.WorkingDay

class BankModel : BankContract.Model {

    override fun getBranch() = Branch(
        id = "34a97c4e-1d97-42f7-ab08-0279aac49178",
        bank = Bank(
            id = "133240fd-5910-421d-b417-5a9cedd5f5f7",
            name = "Unibank",
            rates = createRatesForUniBank()
        ),
        name = "Martuni",
        address = "Tumanyan 3/1/1",
        phone = "(+37443) 004139",
        workingDays = listOf(
            WorkingDay(0, 4, "09:30-16:30"),
            WorkingDay(5, 5, "10:30-14:30")
        )
    )

    private fun createRatesForUniBank() = listOf(
        Rate("USD", 496F, 504F),
        Rate("EUR", 536F, 559F),
        Rate("RUR", 6.2F, 6.8F)
    )

}
