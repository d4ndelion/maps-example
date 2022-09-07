package com.example.maps_example.ui.fragments.map

import android.os.Bundle
import android.view.View
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentMapBinding
import com.example.maps_example.ui.base.BaseFragment
import org.kodein.di.android.x.viewmodel.viewModel
import org.osmdroid.config.Configuration.*
import org.osmdroid.util.BoundingBox
import org.osmdroid.views.CustomZoomButtonsController.Visibility.NEVER
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

private const val DEFAULT_ZOOM_LEVEL = 3.0

class MapFragment : BaseFragment<FragmentMapBinding>(R.layout.fragment_map) {

    override val viewModel: MapVM by viewModel()
    private val locationOverlay by lazy { MyLocationNewOverlay(GpsMyLocationProvider(requireContext()), binding?.mapView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getInstance().load(requireContext(), viewModel.preferences)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
        locationOverlay.enableMyLocation()
        binding?.apply {
            with(mapView) {
                overlays.add(locationOverlay)
                minZoomLevel = DEFAULT_ZOOM_LEVEL
                isVerticalMapRepetitionEnabled = false
                zoomController.setVisibility(NEVER)
                setMultiTouchControls(true)
                setScrollableAreaLimitLatitude(MapView.getTileSystem().maxLatitude, MapView.getTileSystem().minLatitude, 0)
                mapView.zoomToBoundingBox(
                    BoundingBox(
                        MapView.getTileSystem().maxLatitude,
                        MapView.getTileSystem().maxLongitude,
                        MapView.getTileSystem().minLatitude,
                        MapView.getTileSystem().minLongitude
                    ), false
                )
            }
        }
    }
}
