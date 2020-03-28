package com.gevondov.rates.presentation.banks

import com.gevondov.rates.domain.model.Bank
import com.gevondov.rates.domain.model.Rate

class BanksModel : BanksContract.Model {

    override fun getBanks(): List<Bank> {
        return listOf(
            Bank("db08ff22-add9-45ea-a450-1fe5b1993704", "EvocaBank", createRatesForEvocaBank()),
            Bank("133240fd-5910-421d-b417-5a9cedd5f5f7", "UniBank", createRatesForUniBank()),
            Bank("8e9bd4c8-6f4a-4663-ae86-b8fbaf295030", "IdBank", createRatesForIdBank()),
            Bank("65351947-217c-4593-9011-941b88ee7baf", "InecoBank", createRatesInecoBank()),
            Bank("5ee70183-87fe-4799-802e-ef7f5e7323db", "AraratBank", createRatesForAraratBank())
        )
    }

    private fun createRatesForEvocaBank() = listOf(
        Rate("USD", 497F, 504F),
        Rate("EUR", 542F, 560F),
        Rate("RUR", 6.2F, 6.7F)
    )

    private fun createRatesForUniBank() = listOf(
        Rate("USD", 496F, 504F),
        Rate("EUR", 536F, 559F),
        Rate("RUR", 6.2F, 6.8F)
    )

    private fun createRatesForIdBank() = listOf(
        Rate("USD", 497F, 504F),
        Rate("EUR", 542F, 558F),
        Rate("RUR", 6.28F, 6.6F)
    )

    private fun createRatesInecoBank() = listOf(
        Rate("USD", 498F, 505F),
        Rate("EUR", 543F, 560F),
        Rate("RUR", 6.25F, 6.68F)
    )

    private fun createRatesForAraratBank() = listOf(
        Rate("USD", 498F, 504F),
        Rate("EUR", 540F, 564F),
        Rate("RUR", 6.24F, 6.75F)
    )

}