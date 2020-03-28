package com.gevondov.rates.presentation.banks

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.bank.BankFragment
import com.gevondov.rates.presentation.banks.adapter.BanksAdapter
import com.gevondov.rates.presentation.base.BaseFragment
import com.gevondov.rates.presentation.common.adapter.rates.RateListItem
import io.reactivex.Observable

class BanksFragment(
    override val presenter: BanksContract.Presenter
) : BaseFragment<BanksContract.View>(
    R.layout.fragment_banks
), BanksContract.View {

    override val recyclerView: RecyclerView?
        get() = view?.findViewById(R.id.banks)

    override val adapter = BanksAdapter()

    override val bankItemClicks: Observable<String>
        get() = adapter.clicks()
            .filter { it is RateListItem }
            .map { it.id }

    override fun navigateToBank(id: String) {
        val args = bundleOf(BankFragment.ARGS_BANK_ID to id)
        findNavController().navigate(R.id.from_banks_to_bank, args)
    }

}
