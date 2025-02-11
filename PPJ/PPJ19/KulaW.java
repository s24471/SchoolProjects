package com.company;

public class KulaW {
    private double promien;

    public KulaW(Kwadrat k){
        promien=k.getBok()/2;
    }

    public KulaW(Walec w){
        if(w.getWysokosc()/2>w.getPromien())
            promien=w.getPromien();
        else
            promien=w.getWysokosc()/2;
    }
}
