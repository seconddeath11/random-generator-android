package com.example.randomgenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.randomgenerator.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_menu, container, false)
        binding.coinButton.setOnClickListener {v: View ->
            v.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToCoinFragment())
        }
        binding.listButton.setOnClickListener {v: View ->
            v.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToListFragment())
        }
        binding.numberButton.setOnClickListener {v: View ->
            v.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToNumberFragment())
        }
        binding.ballButton.setOnClickListener {v: View ->
            v.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToMagicBallFragment())
        }
        binding.dicesButton.setOnClickListener {v: View ->
            v.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToDiceFragment())
        }
        return binding.root
    }

}