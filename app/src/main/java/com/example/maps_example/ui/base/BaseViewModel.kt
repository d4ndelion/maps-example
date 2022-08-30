package com.example.maps_example.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maps_example.utils.Screens
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val screenChannel = Channel<Screens>()

    fun navigate(destination: Screens) {
        viewModelScope.launch {
            screenChannel.send(destination)
        }
    }
}
