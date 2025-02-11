package com.company;

public class Osoba implements Comparable<Osoba>{
    String nazwisko;
    int wiek;

    public Osoba(String nazwisko, int wiek) {
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    @Override
    public int compareTo(Osoba o) {
        if(this.nazwisko == o.nazwisko) return this.wiek - o.wiek;
        return this.nazwisko.compareTo(o.nazwisko);
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }
}
