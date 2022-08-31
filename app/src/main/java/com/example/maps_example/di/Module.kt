package com.example.maps_example.di

import com.example.maps_example.ui.fragments.map.MapVM
import org.kodein.di.DI.Module
import org.kodein.di.bindProvider

private const val VIEW_MODEL = "viewModelModule"

val viewModelModule = Module(VIEW_MODEL) {
    bindProvider { MapVM() }
}
