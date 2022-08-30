package com.example.maps_example.ui.fragments.enter

import com.example.maps_example.ui.base.BaseViewModel
import com.example.maps_example.utils.Screens.MAP

class EnterVM : BaseViewModel() {

    fun navigateToMap() {
        navigate(MAP)
    }
}
