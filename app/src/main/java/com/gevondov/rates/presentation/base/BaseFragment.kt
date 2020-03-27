package com.gevondov.rates.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gevondov.rates.presentation.base.adapter.BaseAdapter
import com.gevondov.rates.presentation.base.adapter.BaseListItem

abstract class BaseFragment<V : BaseContract.View>(
    @LayoutRes layout: Int
) : Fragment(
    layout
), BaseContract.View {

    protected abstract val recyclerView: RecyclerView?
    protected abstract val adapter: BaseAdapter
    protected abstract val presenter: BaseContract.Presenter<V>

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@BaseFragment.adapter
        }

        presenter.bind(this as V)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.unBind()
    }

    override fun updateItems(newItems: List<BaseListItem>) {
        adapter.updateItems(newItems)
    }

}
