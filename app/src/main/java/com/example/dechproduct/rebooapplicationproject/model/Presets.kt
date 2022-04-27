package com.example.dechproduct.rebooapplicationproject.model

class Presets {
    private val presets = mutableListOf<Preset>()

    constructor() {
        addPreset(Preset("normal", 1f))
        addPreset(Preset("5Hz", 5f))
        addPreset(Preset("15Hz", 15f))
    }

    fun addPreset(preset: Preset) {
        presets.add(element = preset)
    }

    fun removePreset(index: Int) {
        presets.removeAt(index)
    }

    fun getPreset(index: Int): Preset {
        return presets[index]
    }

    fun values(): MutableListIterator<Preset> {
        return presets.listIterator()
    }

}