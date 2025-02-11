package com.company;

public class KulaNa {
    private double promien;

    public KulaNa(Kwadrat k){
        double przekatnaPodstawy=Math.sqrt(2)*k.getBok();
        double przekatnaSzescianu=Math.sqrt(
                przekatnaPodstawy*przekatnaPodstawy+
                k.getBok()*k.getBok());
        promien=przekatnaSzescianu/2;
    }

    public KulaNa(Walec w){
        double przekatnaPodstawy=w.getPromien()*2;
        double przekatnaWalca=Math.sqrt(
                przekatnaPodstawy*przekatnaPodstawy +
                        w.getWysokosc()*w.getWysokosc()
        );
        promien=przekatnaWalca/2;
    }
}
