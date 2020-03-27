package com.gevondov.rates.presentation.banks

import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.banks.adapter.BanksAdapter
import com.gevondov.rates.presentation.base.BaseFragment

class BanksFragment : BaseFragment(R.layout.fragment_banks) {

    override val recyclerView: RecyclerView?
        get() = view?.findViewById(R.id.banks)

    override val adapter = BanksAdapter()

}
