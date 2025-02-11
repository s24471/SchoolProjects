package com.company;

public class Plane implements Flyable{
    @Override
    public String drive() {
        return "Silnikami";
    }

    @Override
    public double distance() {
        return 100;
    }
}
