package com.example.maps_example

import android.app.Application
import com.example.maps_example.di.viewModelModule
import org.kodein.di.DI
import org.kodein.di.DIAware

class App : Application(), DIAware {

    override val di by DI.lazy {
        import(viewModelModule)
    }
}
