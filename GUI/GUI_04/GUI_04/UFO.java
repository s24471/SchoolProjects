package com.company;

public class UFO implements Flyable, Speakable{
    @Override
    public String drive() {
        return "Naped kosmiczny";
    }
    @Override
    public double distance() {
        return 10000;
    }

    @Override
    public String speak() {
        return "IuIuIu";
    }
}
