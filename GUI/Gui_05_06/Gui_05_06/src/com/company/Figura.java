package com.company;

abstract class Figura implements Obliczenie{

    protected int srodek_x, srodek_y;

    public Figura(int srodek_x, int srodek_y) {
        this.srodek_x = srodek_x;
        this.srodek_y = srodek_y;
    }

    // metody abstrakcyjne
    public abstract String fig();
    public abstract void pozycja(int x, int y);

    @Override
    public String toString()
    {
        return fig();
    }
}

