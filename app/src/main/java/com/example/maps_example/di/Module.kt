package com.example.maps_example.di

import androidx.lifecycle.ViewModel
import com.example.maps_example.ui.fragments.first.FirstVM
import org.kodein.di.DI.Module
import org.kodein.di.bind
import org.kodein.di.singleton

private const val VIEW_MODEL = "viewModel"

val viewModelModule = Module(VIEW_MODEL) {
    bind<ViewModel>(tag = FirstVM::class.simpleName) with singleton { FirstVM() }
}
