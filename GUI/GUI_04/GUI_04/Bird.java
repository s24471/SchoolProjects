package com.company;

public class Bird implements Flyable, Speakable{
    @Override
    public String drive() {
        return "Macha skrzydlami";
    }
    @Override
    public double distance() {
        return 10;
    }

    @Override
    public String speak() {
        return "kraakraa";
    }
}
