package com.example.maps_example.ui.fragments.map

import android.os.Bundle
import android.view.View
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentMapBinding
import com.example.maps_example.ui.base.BaseFragment
import com.yandex.mapkit.MapKitFactory
import org.kodein.di.android.x.viewmodel.viewModel

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {

    override val viewModel: MapVM by viewModel()
    private val mapKit by lazy { MapKitFactory.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(requireContext())
    }

    override fun onStart() {
        super.onStart()
        mapKit.onStart()
        binding?.mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapKit.onStop()
        binding?.mapView?.onStop()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
    }
}
