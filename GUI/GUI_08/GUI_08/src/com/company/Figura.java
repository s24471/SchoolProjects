package com.company;

abstract class Figura implements Obliczenie, Comparable<Figura>{
    static int index = 0;
    public int indywid = ++index;
    protected int srodek_x, srodek_y;

    public Figura(int srodek_x, int srodek_y) {
        this.srodek_x = srodek_x;
        this.srodek_y = srodek_y;
    }

    @Override
    public int compareTo(Figura f)
    {
        if (this.pole() - f.pole() < 0)
            return -1;
        if (this.pole() - f.pole() > 0)
            return 1;
        if (this.obwod() - f.obwod() < 0)
            return -1;
        if (this.obwod() - f.obwod() > 0)
            return 1;
        return indywid - f.indywid;

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

