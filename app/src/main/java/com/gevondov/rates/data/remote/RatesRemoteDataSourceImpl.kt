package com.gevondov.rates.data.remote

import com.gevondov.rates.data.remote.network.RatesApi
import com.gevondov.rates.data.remote.response.BankResponse
import com.gevondov.rates.data.remote.response.BranchResponse
import com.gevondov.rates.data.remote.response.RateResponse
import com.gevondov.rates.data.remote.response.WorkingDayResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class RatesRemoteDataSourceImpl(
    private val ratesApi: RatesApi
) : RatesRemoteDataSource {

    val banks = listOf(
        BankResponse("db08ff22-add9-45ea-a450-1fe5b1993704", "EvocaBank", createRatesForEvocaBank()),
        BankResponse("133240fd-5910-421d-b417-5a9cedd5f5f7", "UniBank", createRatesForUniBank()),
        BankResponse("8e9bd4c8-6f4a-4663-ae86-b8fbaf295030", "IdBank", createRatesForIdBank()),
        BankResponse("65351947-217c-4593-9011-941b88ee7baf", "InecoBank", createRatesInecoBank()),
        BankResponse("5ee70183-87fe-4799-802e-ef7f5e7323db", "AraratBank", createRatesForAraratBank())
    )

    override fun getBanks() = ratesApi.getBanks()
        .map { it.banks }

    override fun getBranches(bankId: String): Single<List<BranchResponse>> {
        return Single.just(listOf(createBranch(), createBranch(), createBranch()))
            .delay(2, TimeUnit.SECONDS)
    }

    private fun createBranch(): BranchResponse {
        return BranchResponse(
            id = "34a97c4e-1d97-42f7-ab08-0279aac49178",
            isHead = true,
            name = "Martuni",
            address = "Tumanyan 3/1/1",
            phone = "(+37443) 004139",
            workingDays = listOf(
                WorkingDayResponse("1-5", "09:30-16:30"),
                WorkingDayResponse("6", "10:30-14:30")
            )
        )
    }

    private fun createRatesForEvocaBank() = listOf(
        RateResponse("USD", 497F, 504F),
        RateResponse("EUR", 542F, 560F),
        RateResponse("RUR", 6.2F, 6.7F)
    )

    private fun createRatesForUniBank() = listOf(
        RateResponse("USD", 496F, 504F),
        RateResponse("EUR", 536F, 559F),
        RateResponse("RUR", 6.2F, 6.8F)
    )

    private fun createRatesForIdBank() = listOf(
        RateResponse("USD", 497F, 504F),
        RateResponse("EUR", 542F, 558F),
        RateResponse("RUR", 6.28F, 6.6F)
    )

    private fun createRatesInecoBank() = listOf(
        RateResponse("USD", 498F, 505F),
        RateResponse("EUR", 543F, 560F),
        RateResponse("RUR", 6.25F, 6.68F)
    )

    private fun createRatesForAraratBank() = listOf(
        RateResponse("USD", 498F, 504F),
        RateResponse("EUR", 540F, 564F),
        RateResponse("RUR", 6.24F, 6.75F)
    )
}
