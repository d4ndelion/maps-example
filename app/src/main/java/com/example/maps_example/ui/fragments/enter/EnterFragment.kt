package com.example.maps_example.ui.fragments.enter

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions
import androidx.fragment.app.viewModels
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentEnterBinding
import com.example.maps_example.ui.base.BaseFragment

class EnterFragment : BaseFragment<FragmentEnterBinding>(R.layout.fragment_enter) {

    override val viewModel by viewModels<EnterVM>()
    private val permissions = arrayOf(ACCESS_COARSE_LOCATION, ACCESS_FINE_LOCATION)
    private val locationPermission = registerForActivityResult(RequestMultiplePermissions()) {
        if (it.all { permission -> permission.value }) {
            Log.d("asdasd", "OK")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.vm = viewModel
        locationPermission.launch(permissions)
    }
}
