package com.example.maps_example.domain.repository.interfaces

import android.content.SharedPreferences

interface IPreferenceRepository {
    val preferencesInstance: SharedPreferences
    suspend fun clear()
}
