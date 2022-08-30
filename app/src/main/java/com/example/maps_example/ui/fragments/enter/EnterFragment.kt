package com.example.maps_example.ui.fragments.enter

import androidx.fragment.app.viewModels
import com.example.maps_example.R
import com.example.maps_example.databinding.FragmentEnterBinding
import com.example.maps_example.ui.base.BaseFragment

class EnterFragment : BaseFragment<FragmentEnterBinding>(R.layout.fragment_enter) {

    override val viewModel by viewModels<EnterVM>()

}
