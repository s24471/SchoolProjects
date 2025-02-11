package com.company;

public class Walec {
    private double promien;
    private double wysokosc;

    public Walec(double promien, double wysokosc){
        this.promien=promien;
        this.wysokosc=wysokosc;
    }

    public void show(){
        System.out.println("pole okręgu "+Math.PI*promien*promien);
        System.out.println("objetosc walca "+Math.PI*promien*promien*wysokosc);
    }

    public double getPromien(){return promien;}
    public double getWysokosc(){return wysokosc;}
}
