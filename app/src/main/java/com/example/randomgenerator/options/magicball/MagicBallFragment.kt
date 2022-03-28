package com.example.randomgenerator.options.magicball

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.randomgenerator.R
import com.example.randomgenerator.databinding.FragmentMagicBallBinding


class MagicBallFragment : Fragment() {
    private lateinit var binding: FragmentMagicBallBinding
    private lateinit var viewModel: MagicBallViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_magic_ball, container, false)
        viewModel = ViewModelProvider(this).get(MagicBallViewModel::class.java)
        val array = resources.getStringArray(R.array.options_array).toList()

        binding.getAnswerButton.setOnClickListener {
            val value = viewModel.onChoose(array)
            binding.text.text = value
        }
        return binding.root
    }
}