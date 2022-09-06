package com.example.maps_example.ui.fragments.map

import com.example.maps_example.domain.repository.interfaces.IPreferenceRepository
import com.example.maps_example.ui.base.BaseViewModel

class MapVM(prefs: IPreferenceRepository) : BaseViewModel() {

    val preferences = prefs.preferencesInstance
}
