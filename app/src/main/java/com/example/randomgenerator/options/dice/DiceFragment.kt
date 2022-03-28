package com.example.randomgenerator.options.dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomgenerator.R
import com.example.randomgenerator.databinding.FragmentDiceBinding


class DiceFragment : Fragment() {
    private lateinit var binding: FragmentDiceBinding
    private lateinit var viewModel: DiceViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_dice, container, false)
        viewModel = ViewModelProvider(this).get(DiceViewModel::class.java)
        val adapter = DiceAdapter()
        binding.recyclerView.adapter = adapter

        binding.numberOfAnswers.minValue = 1
        binding.numberOfAnswers.maxValue = 16

        viewModel.list.observe(viewLifecycleOwner) { list ->
            if (list != null) {
                adapter.data = list
            }
        }
        binding.chooseButton.setOnClickListener {
            val num = binding.numberOfAnswers.value
            viewModel.onChoose(num)
        }
        return binding.root
    }
}