package com.example.dechproduct.rebooapplicationproject.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import com.example.dechproduct.rebooapplicationproject.model.MediaController
import com.example.dechproduct.rebooapplicationproject.model.Preset
import com.example.dechproduct.rebooapplicationproject.model.Presets

class OpenAudioViewModel : ViewModel (){

    private val tasksEventChannel = Channel<ExampleAddEvent>()
    val tasksEvent = tasksEventChannel.receiveAsFlow()
    private val controller: MediaController = MediaController()
    val presets = Presets()
    val liveData = MutableLiveData<Any>()
    private var i: Int = 0

    fun setLiveData() {
        liveData.value = presets
    }

    fun onAddNewTaskClick() = viewModelScope.launch {
        tasksEventChannel.send(ExampleAddEvent.NavigateToPlayTaskScreen)
    }


    sealed class ExampleAddEvent {
        object NavigateToPlayTaskScreen : ExampleAddEvent()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun record() {
        println("Recording")
        when (i%4) {
            0-> controller.startRecord()
            1-> controller.stopRecord()
            2-> controller.startPlayback(Preset("Man", pitch = 1f), 1f)
            3 -> controller.stopPlayback()
        }
        i++
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun playPause(preset: Preset, speed: Float) {
        if(controller.isPlaying) {
            controller.stopPlayback()
        } else {
            controller.startPlayback(preset, speed)
        }
    }

    fun setRepeat() {
        controller.looping()
    }

    fun addAudio(name: String) {
        controller.saveToDevice(name)
    }

    fun deleteAudio() {

    }

}