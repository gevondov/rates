package com.gevondov.rates.presentation.bank

import com.gevondov.rates.mappers.BankHeaderListItemMapper
import com.gevondov.rates.mappers.RateListItemMapper
import com.gevondov.rates.presentation.base.BasePresenter

class BankPresenter(
    private val model: BankContract.Model,
    private val bankHeaderListItemMapper: BankHeaderListItemMapper,
    private val rateListItemMapper: RateListItemMapper
) : BasePresenter<BankContract.View>(), BankContract.Presenter {

    override lateinit var id: String

    override fun bind(view: BankContract.View) {
        super.bind(view)

        addDisposable(model.getBranch(id)
            .map { listOf(bankHeaderListItemMapper.fromBranch(it)) + rateListItemMapper.fromBank(it.bank)}
            .subscribe(view::updateItems, Throwable::printStackTrace))
    }

}
