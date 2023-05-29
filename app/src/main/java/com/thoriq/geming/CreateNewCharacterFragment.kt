package com.thoriq.geming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.thoriq.geming.`class`.Orang
import com.thoriq.geming.`class`.Pemain
import com.thoriq.geming.databinding.FragmentCreateNewCharacterBinding

class CreateNewCharacterFragment : Fragment() {
    lateinit var binding:FragmentCreateNewCharacterBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCreateNewCharacterBinding.inflate(layoutInflater)
        binding.CreateButton.setOnClickListener{view:View ->view.findNavController().navigate(R.id.action_createNewCharacterFragment_to_menuFragment)}
        return binding.root
    }
    fun chooseCharacter():Orang{
        val tipePemain = when (binding.CharOption.checkedRadioButtonId) {
            R.id.Fighter -> Orang(10,1,3)
            else -> Orang(5,3,5)
        }
        return tipePemain
    }
}
