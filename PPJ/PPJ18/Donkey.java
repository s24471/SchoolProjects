package com.company;

public class Donkey {
    private double mass;
    private Baloon[] baloons;

    public Donkey(double mass){
        this.mass=mass;
        baloons=new Baloon[0];
    }

    public void addBaloon(Baloon b){
        Baloon [] newBaloons=new Baloon[baloons.length+1];

        for (int i = 0; i < baloons.length; i++) {
            newBaloons[i]=baloons[i];
        }
        newBaloons[newBaloons.length-1]=b;

        baloons=newBaloons;
    }

    public boolean isFlying(){
        double load=0;
        for (int i = 0; i < baloons.length; i++) {
            load+=baloons[i].getLoad();
        }
        if(load>=mass)return true;
        return false;

    }

}
