package com.example.maps_example.ui.fragments.map

import android.os.Bundle
import android.view.View
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentMapBinding
import com.example.maps_example.ui.base.BaseFragment
import com.example.maps_example.utils.LocationOverlayObserver
import org.kodein.di.android.x.viewmodel.viewModel
import org.osmdroid.config.Configuration.*

private const val ZOOM_LEVEL_CLOSE = 18.0

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {

    override val viewModel: MapVM by viewModel()
    private val locationOverlay by lazy { LocationOverlayObserver(binding?.mapView, requireContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInstance().load(requireContext(), viewModel.preferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
        locationOverlay.enableMyLocation()
        binding?.apply {
            mapView.setup(locationOverlay)
            locationOverlay.currentLocation observe { currentPoint ->
                if (currentPoint == null) return@observe
                with(mapView.controller) {
                    animateTo(currentPoint)
                    setZoom(ZOOM_LEVEL_CLOSE)
                }
            }
        }
    }
}
