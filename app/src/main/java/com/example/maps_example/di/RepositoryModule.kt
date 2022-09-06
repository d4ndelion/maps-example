package com.example.maps_example.di

import com.example.maps_example.domain.repository.PreferenceRepository
import com.example.maps_example.domain.repository.interfaces.IPreferenceRepository
import org.kodein.di.DI.Module
import org.kodein.di.bindSingleton
import org.kodein.di.instance

private const val REPOSITORY = "repositoryModule"

val repositoryModule = Module(REPOSITORY) {
    bindSingleton<IPreferenceRepository> { PreferenceRepository(instance()) }
}
