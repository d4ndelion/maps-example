package com.example.maps_example

import android.app.Application
import com.example.maps_example.BuildConfig.YANDEX_MAP_KIT_SDK_KEY
import com.example.maps_example.di.viewModelModule
import com.yandex.mapkit.MapKitFactory
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@App))
        import(viewModelModule)
    }

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(YANDEX_MAP_KIT_SDK_KEY)
    }
}
