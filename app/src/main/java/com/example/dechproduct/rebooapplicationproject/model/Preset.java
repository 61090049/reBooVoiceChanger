package com.example.dechproduct.rebooapplicationproject.model;

public class Preset{

    private String _Name;
    private float _Pitch;
    private float _Speed;

    public Preset(String Name, float Pitch, float Speed){
        _Name = Name;
        _Pitch = Pitch;
        _Speed = Speed;
    }

    public String getName() {
        return _Name;
    }

    public void setName(String Name) {
        _Name = Name;
    }

    public float getPitch() {
        return (int) _Pitch;
    }

    public void setPitch(float Pitch) {
        _Pitch = Pitch;
    }

    public float getSpeed() {
        return _Speed;
    }

    public void setSpeed(float Speed) {
        _Speed = Speed;
    }
}
