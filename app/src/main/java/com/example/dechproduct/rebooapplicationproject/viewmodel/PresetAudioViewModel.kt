package com.example.dechproduct.rebooapplicationproject.viewmodel

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.dechproduct.rebooapplicationproject.model.Categories
import com.example.dechproduct.rebooapplicationproject.model.MediaController
import com.example.dechproduct.rebooapplicationproject.model.Preset

class PresetAudioViewModel: ViewModel () {
    private val controller: MediaController = MediaController()
    private var i: Int = 0

    @RequiresApi(Build.VERSION_CODES.M)
    fun record() {
        println("Recording")
        when (i%4) {
            0-> controller.startRecord()
            1-> controller.stopRecord()
            2-> controller.startPlayback(Preset("Man",1f,1f))
            3 -> controller.stopPlayback()
        }
        i++
    }

    fun addPreset(preset: Preset) {

    }

    fun deletePreset() {

    }
}