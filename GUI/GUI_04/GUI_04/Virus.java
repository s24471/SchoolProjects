package com.company;

public class Virus implements Flyable{
    @Override
    public String drive() {
        return "lata bo jest maly";
    }

    @Override
    public double distance() {
        return 1;
    }

}
