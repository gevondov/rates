package com.gevondov.rates.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.presentation.base.adapter.BaseAdapter

abstract class BaseFragment(
    @LayoutRes layout: Int
) : Fragment(
    layout
) {

    protected abstract val recyclerView: RecyclerView?
    protected abstract val adapter: BaseAdapter

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@BaseFragment.adapter
        }
    }

}
