package com.example.maps_example.utils

import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import com.example.maps_example.R

enum class Screens(@IdRes val screenId: Int, var navDirections: NavDirections? = null) {
    ENTER(R.id.enterFragment),
    MAP(R.id.mapFragment);
}
