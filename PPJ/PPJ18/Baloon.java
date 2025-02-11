package com.company;

public class Baloon {
    double pojemnosc;

    public Baloon(){
        pojemnosc=Math.random()*0.004+0.005;
    }

    public double getLoad(){
        double mass=pojemnosc*6 / 0.007;
        return mass;
    }
}
