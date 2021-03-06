package com.gevondov.rates.presentation.banks

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.R
import com.gevondov.rates.presentation.bank.BankFragment
import com.gevondov.rates.presentation.banks.adapter.BanksAdapter
import com.gevondov.rates.presentation.base.BaseFragment
import com.gevondov.rates.presentation.common.adapter.rates.RateListItem
import com.jakewharton.rxbinding3.view.clicks
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

    override val currencySelectorClicks: Observable<Unit>
        get() = view?.findViewById<View>(R.id.currency_selector_background)?.clicks() ?: Observable.empty()

    override fun navigateToBank(id: String) {
        val args = bundleOf(BankFragment.ARGS_BANK_ID to id)
        findNavController().navigate(R.id.from_banks_to_bank, args)
    }

    override fun showCurrency(currency: String) {
        view?.findViewById<TextView>(R.id.currency_selector)?.text = currency
    }

    override fun showCurrencies(currencies: List<String>, currentCurrency: String) {
        val selectedPosition = currencies.indexOfFirst { it == currentCurrency }
        AlertDialog.Builder(requireContext())
            .setSingleChoiceItems(currencies.toTypedArray(), selectedPosition) { dialog, position ->
                presenter.onCurrencySelected(currencies[position])
                dialog.dismiss()
            }
            .setTitle(R.string.select_currency)
            .show()
    }

}
