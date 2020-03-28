package com.gevondov.rates.presentation.bank

import com.gevondov.rates.mappers.BankHeaderListItemMapper
import com.gevondov.rates.mappers.RateListItemMapper
import com.gevondov.rates.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers

class BankPresenter(
    private val model: BankContract.Model,
    private val bankHeaderListItemMapper: BankHeaderListItemMapper,
    private val rateListItemMapper: RateListItemMapper
) : BasePresenter<BankContract.View>(), BankContract.Presenter {

    override lateinit var bankId: String

    override fun bind(view: BankContract.View) {
        super.bind(view)

        loadBranch(view)

        addDisposable(model.refreshBranch(bankId)
            .subscribe({}, Throwable::printStackTrace))

        addDisposable(model.observeBranchChanges()
            .subscribe({ loadBranch(view) }, Throwable::printStackTrace))
    }

    private fun loadBranch(view: BankContract.View) {
        addDisposable(model.getBranch(bankId)
            .map { listOf(bankHeaderListItemMapper.fromBranch(it)) + rateListItemMapper.fromBank(it.bank) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(view::updateItems, Throwable::printStackTrace))
    }

}
