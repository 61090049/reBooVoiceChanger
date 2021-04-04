package com.example.dechproduct.rebooapplicationproject.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class OpenAudioViewModel : ViewModel (){

    private val tasksEventChannel = Channel<ExampleAddEvent>()
    val tasksEvent = tasksEventChannel.receiveAsFlow()


    fun onAddNewTaskClick() = viewModelScope.launch {
        tasksEventChannel.send(ExampleAddEvent.NavigateToPlayTaskScreen)
    }


    sealed class ExampleAddEvent {
        object NavigateToPlayTaskScreen : ExampleAddEvent()
    }




}