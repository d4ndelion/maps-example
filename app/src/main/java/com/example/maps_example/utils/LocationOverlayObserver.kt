package com.example.maps_example.utils

import android.content.Context
import android.location.Location
import kotlinx.coroutines.flow.MutableStateFlow
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class LocationOverlayObserver(mapView: MapView?, context: Context) : MyLocationNewOverlay(GpsMyLocationProvider(context), mapView) {

    val currentLocation = MutableStateFlow<GeoPoint?>(null)

    override fun onLocationChanged(location: Location?, source: IMyLocationProvider?) {
        super.onLocationChanged(location, source)
        currentLocation.value = myLocation
    }
}
