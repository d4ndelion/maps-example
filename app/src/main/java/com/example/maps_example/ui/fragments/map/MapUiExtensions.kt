package com.example.maps_example.ui.fragments.map

import com.example.maps_example.utils.LocationOverlayObserver
import org.osmdroid.util.BoundingBox
import org.osmdroid.views.MapView

private const val DEFAULT_ZOOM_LEVEL = 3.0
private const val NO_EXTRA_PIXEL_HEIGHT = 0

fun MapView.setup(locationOverlay: LocationOverlayObserver) {
    apply {
        overlays.add(locationOverlay)
        minZoomLevel = DEFAULT_ZOOM_LEVEL
        isVerticalMapRepetitionEnabled = false
        // zoomController.setVisibility(NEVER)
        setMultiTouchControls(true)
        setScrollableAreaLimitLatitude(
            MapView.getTileSystem().maxLatitude,
            MapView.getTileSystem().minLatitude,
            NO_EXTRA_PIXEL_HEIGHT
        )
        zoomToBoundingBox(
            BoundingBox(
                MapView.getTileSystem().maxLatitude,
                MapView.getTileSystem().maxLongitude,
                MapView.getTileSystem().minLatitude,
                MapView.getTileSystem().minLongitude
            ), false
        )
    }
}
