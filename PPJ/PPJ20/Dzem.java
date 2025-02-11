package com.company;

public class Dzem {
    private String name;
    private double waga;

    public Dzem (String name, double waga){
        this.waga=waga;
        this.name=name;
    }

    public Dzem(String name){
        this(name,100.0);
    }

    public Dzem(double waga){
        this("No name",waga);
    }
}
