package com.company;

public class Kwadrat {
    private double bok;

    public Kwadrat(double bok){
        this.bok=bok;
    }

    public void show(){
        System.out.println("Pole kwadratu "+bok*bok);
        System.out.println("Objetosc szescianu "
                +bok*bok*bok);
    }

    public double getBok(){return bok;}
}
