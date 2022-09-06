package com.example.maps_example

import android.app.Application
import com.example.maps_example.di.repositoryModule
import com.example.maps_example.di.viewModelModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class App : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@App))
        import(viewModelModule)
        import(repositoryModule)
    }
}
