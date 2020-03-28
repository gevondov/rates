package com.gevondov.rates.container

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.gevondov.rates.presentation.bank.BankFragment
import com.gevondov.rates.presentation.banks.BanksFragment
import org.koin.core.KoinComponent
import org.koin.core.get

class ContainerFragmentFactory : FragmentFactory(), KoinComponent {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            BanksFragment::class.java.name -> BanksFragment(get())
            BankFragment::class.java.name -> BankFragment(get())
            else -> super.instantiate(classLoader, className)
        }
    }

}
