package com.company;

public class Fruit {
    String name;
    double weight;

    public Fruit(String name){
        weight=Math.random()*0.3+0.5;
        this.name=name;
    }

    public void show(){
        System.out.println(name+" "+weight);
    }
}
