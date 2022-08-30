package com.example.maps_example.ui.fragments.first

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentFirstBinding
import com.example.maps_example.ui.base.BaseFragment

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    override val viewModel by viewModels<FirstVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
    }
}
