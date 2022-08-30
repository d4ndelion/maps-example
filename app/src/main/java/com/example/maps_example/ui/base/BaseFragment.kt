package com.example.maps_example.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI
import org.kodein.di.subDI

abstract class BaseFragment<BINDING : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment() {

    abstract val viewModel: BaseViewModel
    var binding: BINDING? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding?.lifecycleOwner = this.viewLifecycleOwner
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
