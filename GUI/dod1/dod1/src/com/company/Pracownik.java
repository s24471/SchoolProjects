package com.company;

import java.net.PortUnreachableException;

public class Pracownik extends Osoba {
    private Stanowisko stanowisko;
    private int staz;

    public Pracownik(String nazwisko, int wiek, Stanowisko stanowisko, int staz) {
        super(nazwisko, wiek);
        this.stanowisko = stanowisko;
        this.staz = staz;
    }
    public double obliczPensje()
    {
        return staz*stanowisko.pobierzPensjePodstawowa()/2;
    }

    @Override
    public String toString() {
        return super.toString() + "Staz - " + staz + "\nStanowisko - " + stanowisko + "(" + stanowisko.pobierzPensjePodstawowa()+")\nPensja - " + obliczPensje() + '\n';
    }
}
