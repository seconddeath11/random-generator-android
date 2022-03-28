package com.example.randomgenerator.options.number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomgenerator.R
import com.example.randomgenerator.databinding.FragmentNumberBinding
import java.lang.NumberFormatException

class NumberFragment : Fragment() {
    private lateinit var binding: FragmentNumberBinding
    private lateinit var viewModel: NumberViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_number, container, false)
        viewModel = ViewModelProvider(this).get(NumberViewModel::class.java)
        binding.chooseButton.setOnClickListener {
            try {
                val from = binding.fromNumber.text.toString().toInt()
                val to = binding.toNumber.text.toString().toInt()
                val number = binding.number.text.toString().toInt()
                val list: List<Int> = if (binding.checkboxDifferent.isChecked) {
                    viewModel.onChooseDifferent(from, to, number)
                } else {
                    viewModel.onChoose(from, to, number)
                }
                binding.chosenValues.text = list.toString().slice(1 until list.toString().length-1)
            }catch (e: NumberFormatException){
                binding.chosenValues.text = null
            }
        }
        return binding.root
    }
}