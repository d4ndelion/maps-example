package com.example.maps_example.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.maps_example.utils.Screens
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.closestDI

abstract class BaseFragment<BINDING : ViewDataBinding>(@LayoutRes private val layoutResId: Int) : Fragment(), DIAware {

    abstract val viewModel: BaseViewModel
    override val di: DI by closestDI()
    var binding: BINDING? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)
        binding?.lifecycleOwner = this.viewLifecycleOwner
        lifecycleScope.launch {
            receiveScreen(viewModel.screenChannel.receive())
        }
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun navigate(destination: Screens) {
        runCatching {
            if (destination.navDirections != null) {
                findNavController().navigate(destination.navDirections!!)
                return
            }
            findNavController().navigate(destination.screenId)
        }
    }

    private fun receiveScreen(screen: Screens?) {
        navigate(screen ?: return)
    }
}
