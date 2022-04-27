package com.example.dechproduct.rebooapplicationproject.fragments

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dechproduct.rebooapplicationproject.R
import com.example.dechproduct.rebooapplicationproject.databinding.FragmentPlayAudioBinding
import com.example.dechproduct.rebooapplicationproject.model.Preset
import com.example.dechproduct.rebooapplicationproject.viewmodel.OpenAudioViewModel
import kotlinx.android.synthetic.main.fragment_preset_audio.*


class PlayAudioFragment : Fragment(R.layout.fragment_play_audio) {

    private var _binding: FragmentPlayAudioBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: OpenAudioViewModel
    private var speed: Float = 1f

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayAudioBinding.inflate(
                inflater, container, false
        )

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(OpenAudioViewModel::class.java)
        binding.ibCover.setOnClickListener { record() }
        binding.seekBar.setOnSeekBarChangeListener(changePitch())
        binding.ibPlay.setOnClickListener {playPause()}
        binding.ibRepeat.setOnClickListener {setRepeat()}
        binding.ibFavorite.setOnClickListener {addAudio()}
        binding.ibDelete.setOnClickListener {deleteAudio()}
        binding.ibForwardSong.setOnClickListener {faster()}
        binding.ibBackwardSong.setOnClickListener {slower()}
        binding.categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val preset = viewModel.presets.getPreset(position)
                binding.seekBar.progress = preset.pitch.toInt()
            }
        }

        setUpPresets()
    }


    private fun setUpPresets() {
        viewModel.setLiveData()
        viewModel.liveData.observe(viewLifecycleOwner, object : Observer<Any> {
            override fun onChanged(o: Any?) {
                val preset = mutableListOf<String>()
                viewModel.presets.values().forEach { preset.add(it.name) }
                val arrayAdapter =
                        ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, preset)
                category_spinner.adapter = arrayAdapter
            }
        })
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun record() {
        viewModel.record()
    }

    private fun changePitch(): SeekBar.OnSeekBarChangeListener {
        // Set a SeekBar change listener
        return object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                // Display the current progress of SeekBar
                binding.pitch.text = "$i"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        }
    }

    private fun getPitch(): Float {
        return binding.pitch.text.toString().toFloat()
    }

    private fun getPreset(): Preset {
        return Preset(binding.categorySpinner.selectedItem.toString(), pitch = getPitch())
    }

    private fun getSpeed(): Float {
        return speed
    }

    private fun setRepeat() {
        viewModel.setRepeat()
    }

    private fun addAudio() {
        viewModel.addAudio(binding.tvTitle.text.toString())
    }

    private fun deleteAudio() {
        viewModel.deleteAudio()
    }
    private fun faster() {
        if (speed < 2f) {
            speed += 0.25f
        }
        println(speed)
    }

    private fun slower() {
        if (speed > 0.25f) {
            speed -= 0.25f
        }
        println(speed)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun playPause() {
        viewModel.playPause(getPreset(), getSpeed())
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()

    }





}