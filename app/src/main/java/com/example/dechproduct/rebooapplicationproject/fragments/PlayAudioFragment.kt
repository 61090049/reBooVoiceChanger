package com.example.dechproduct.rebooapplicationproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.dechproduct.rebooapplicationproject.R
import com.example.dechproduct.rebooapplicationproject.databinding.FragmentPlayAudioBinding
import com.example.dechproduct.rebooapplicationproject.model.Categories
import kotlinx.android.synthetic.main.fragment_preset_audio.*


class PlayAudioFragment : Fragment(R.layout.fragment_play_audio) {

    private var _binding : FragmentPlayAudioBinding ?= null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayAudioBinding.inflate(
            inflater,container,false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCategories()
    }

    private fun setUpCategories(){
        val categories = mutableListOf<String>()
        Categories.values().forEach { categories.add(it.name) }
        val arrayAdapter =
            ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, categories)
        category_spinner.adapter = arrayAdapter

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()

    }

}