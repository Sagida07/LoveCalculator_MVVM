package com.example.lovecalculator_mvvm.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator_mvvm.data.local.Pref
import com.example.lovecalculator_mvvm.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator_mvvm.onboarding.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {
    @Inject
    lateinit var pref: Pref
    private lateinit var binding: FragmentOnBoardingBinding

    private val adapter = OnBoardingAdapter(this::onClick)

    private fun onClick() {
        pref.onShowed()
        findNavController().navigateUp()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        binding.indicator.setViewPager(binding.viewPager)
    }
}