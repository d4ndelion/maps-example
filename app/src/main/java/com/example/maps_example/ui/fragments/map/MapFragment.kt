package com.example.maps_example.ui.fragments.map

import android.os.Bundle
import android.view.View
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentMapBinding
import com.example.maps_example.ui.base.BaseFragment
import org.kodein.di.android.x.viewmodel.viewModel
import org.osmdroid.config.Configuration.*

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {

    override val viewModel: MapVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInstance().load(requireContext(), viewModel.preferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
    }
}
