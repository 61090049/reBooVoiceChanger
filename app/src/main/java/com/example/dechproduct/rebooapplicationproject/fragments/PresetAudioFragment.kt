package com.example.dechproduct.rebooapplicationproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.dechproduct.rebooapplicationproject.R
import com.example.dechproduct.rebooapplicationproject.databinding.FragmentPresetAudioBinding
import com.example.dechproduct.rebooapplicationproject.model.Categories
import kotlinx.android.synthetic.main.fragment_preset_audio.*


class PresetAudioFragment : Fragment(R.layout.fragment_preset_audio_ckicked) {

    private var _binding : FragmentPresetAudioBinding? = null
    private val binding get() =  _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPresetAudioBinding.inflate(
            inflater, container, false
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