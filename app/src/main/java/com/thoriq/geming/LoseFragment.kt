package com.thoriq.geming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.thoriq.geming.databinding.FragmentLoseBinding
import com.thoriq.geming.databinding.FragmentWinBinding


class LoseFragment : Fragment() {

    lateinit var binding: FragmentLoseBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLoseBinding.inflate(layoutInflater)
        binding.LanjutButton.setOnClickListener { view:View->view.findNavController().navigate(R.id.action_loseFragment_to_menuFragment) }
        return binding.root
    }
}