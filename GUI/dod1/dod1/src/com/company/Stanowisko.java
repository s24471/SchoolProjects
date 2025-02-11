package com.company;

public enum Stanowisko {
    Projektant(2000), // Projektant ma pensję podstawową = 2000
    Programista(1500),
    Tester(1000);
    private double pensja;

    Stanowisko(double pensja) {
        this.pensja = pensja;
    }

    public double pobierzPensjePodstawowa() {
        return pensja;
    }
}
