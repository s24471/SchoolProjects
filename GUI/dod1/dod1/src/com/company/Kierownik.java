package com.company;

public class Kierownik extends Pracownik{
    private String dzial;

    public Kierownik(String nazwisko, int wiek, Stanowisko stanowisko, int staz, String dzial) {
        super(nazwisko, wiek, stanowisko, staz);
        this.dzial = dzial;
    }

    @Override
    public double obliczPensje() {
        return super.obliczPensje()*2;
    }

    @Override
    public String toString() {
        return super.toString()+"Kierownik dzialu - " + dzial + "\n";
    }
}
