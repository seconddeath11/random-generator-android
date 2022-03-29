package com.example.randomgenerator.options.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomgenerator.R
import com.example.randomgenerator.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ListViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_list, container, false)

        val adapter = ListAdapter()
        binding.recyclerView.adapter = adapter


        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.list.observe(viewLifecycleOwner) { list ->
            if (list != null) {
                adapter.data = list
            }else{
                adapter.data = mutableListOf()
            }
        }
        binding.addButton.setOnClickListener{
            val text = binding.addText.text.toString()
            if (text != "")
                viewModel.onAdd(text)
            binding.addText.text = null
        }
        binding.chooseButton.setOnClickListener {
            try {
                val num = binding.numberOfAnswers.text.toString().toInt()
                val answer = viewModel.onChoose(num).toString()
                binding.answers.text = answer.slice(1 until answer.length - 1)
            } catch (e: NumberFormatException){
                binding.answers.text = null
            }

        }
        binding.clearButton.setOnClickListener{
            viewModel.onClear()
            binding.answers.text = null
        }
        return binding.root
    }

}