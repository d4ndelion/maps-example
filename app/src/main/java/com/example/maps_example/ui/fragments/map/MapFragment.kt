package com.example.maps_example.ui.fragments.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentMapBinding
import com.example.maps_example.ui.base.BaseFragment

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {

    override val viewModel by viewModels<MapVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
    }

}
