package com.gevondov.rates.presentation.bank

import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.bank.adapter.BankAdapter
import com.gevondov.rates.presentation.base.BaseFragment

class BankFragment(
    override val presenter: BankContract.Presenter
) : BaseFragment<BankContract.View>(
    R.layout.fragment_bank
), BankContract.View {

    companion object {
        const val ARGS_BANK_ID = "args.bank_id"
    }

    override val recyclerView: RecyclerView?
        get() = view?.findViewById(R.id.bank)

    override val adapter = BankAdapter()

}
