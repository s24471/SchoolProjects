package com.company;

public class Osoba {
    private String nazwisko;
    private int wiek;

    public Osoba(String nazwisko, int wiek) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public int getWiek() {
        return wiek;
    }

    @Override
    public String toString() {
        return "Nazwisko - " + nazwisko + '\n' +
                "Wiek - " + wiek + "\n";
    }
}
