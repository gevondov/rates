package com.gevondov.rates.presentation.banks

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.banks.adapter.BankListItem
import com.gevondov.rates.presentation.banks.adapter.BanksAdapter
import com.gevondov.rates.presentation.base.BaseFragment

class BanksFragment : BaseFragment(
    R.layout.fragment_banks
), BanksContract.View {

    override val recyclerView: RecyclerView?
        get() = view?.findViewById(R.id.banks)

    override val adapter = BanksAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateItems(listOf(
            BankListItem("EvocaBank", 484.5F, 487F),
            BankListItem("UniBank", 484F, 487.5F),
            BankListItem("IdBank", 484.5F, 487.5F),
            BankListItem("InecoBank", 484.5F, 487.25F),
            BankListItem("AraratBank", 484F, 487F),
            BankListItem("HayEconomBank", 484.5F, 487.5F)
        ))
    }

}
