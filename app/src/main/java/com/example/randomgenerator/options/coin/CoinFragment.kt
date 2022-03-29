package com.example.randomgenerator.options.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.randomgenerator.R
import com.example.randomgenerator.databinding.FragmentCoinBinding

class CoinFragment : Fragment() {
    private lateinit var binding: FragmentCoinBinding
    private lateinit var viewModel: CoinViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_coin, container, false)
        viewModel = CoinViewModel()
        binding.flipButton.setOnClickListener {
               viewModel.onFlip()
        }
        viewModel.coinImage.observe(viewLifecycleOwner) { image ->
            binding.coinImage.animate().apply {
                duration = 500
                rotationYBy(720f)
            }
            binding.coinImage.setImageResource(image)

        }
        return binding.root
    }

}