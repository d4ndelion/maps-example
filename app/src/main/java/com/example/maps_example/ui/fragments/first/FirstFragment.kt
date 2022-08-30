package com.example.maps_example.ui.fragments.first

import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentFirstBinding
import com.example.maps_example.ui.base.BaseFragment
import org.kodein.di.android.di
import org.kodein.di.instance

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    override val viewModel = FirstVM()

}
