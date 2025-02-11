package com.company;

public class Osoba {
    private String imie;
    private int rokUrodzenia;

    public Osoba(String imie,int rokUrodzenia){
        this.imie=imie;
        this.rokUrodzenia=rokUrodzenia;
    }

    public Osoba(String imie){
//        this.imie=imie;
//        rokUrodzenia=1990;
        this(imie,1990);//wywołanie konstruktora
    }

    public String zwrocImie(){return imie;}
    public int zwrocWiek(){return 2021-rokUrodzenia;}

    public static Osoba zwrocStarszaOsobe(Osoba o1, Osoba o2){
        if(o1.zwrocWiek()>o2.zwrocWiek()) return o1;
        return o2;
    }

    public static Osoba zwrocNajstarszaOsobe(Osoba[] osoby){
        Osoba najstrasza=osoby[0];
        for (int i = 1; i < osoby.length; i++) {
            if(najstrasza.zwrocWiek()<osoby[i].zwrocWiek())
                najstrasza=osoby[i];
        }
        return najstrasza;
    }
}
