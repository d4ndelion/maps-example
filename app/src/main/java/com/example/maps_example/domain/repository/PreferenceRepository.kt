package com.example.maps_example.domain.repository

import android.content.Context
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.maps_example.domain.repository.interfaces.IPreferenceRepository

private const val PREFERENCES = "maps_example_preferences"

class PreferenceRepository(context: Context) : IPreferenceRepository {

    override val preferencesInstance = EncryptedSharedPreferences.create(
        context,
        PREFERENCES,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override suspend fun clear() {
        preferencesInstance.edit {
            // remove()
        }
    }
}
