package com.example.maps_example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.maps_example.databinding.ActivityMainBinding
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI

class AppActivity : AppCompatActivity(), DIAware {

    override val di: DI by closestDI()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
