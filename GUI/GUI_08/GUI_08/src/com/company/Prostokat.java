package com.company;

class Prostokat extends Figura implements Obliczenie{

    protected int szer, wys;

    // konstruktor


    public Prostokat(int srodek_x, int srodek_y, int szer, int wys) {
        super(srodek_x, srodek_y);
        this.szer = szer;
        this.wys = wys;
    }

    @Override
    public String fig() {
        return "Prostokat";
    }

    @Override
    public void pozycja(int x, int y)
    {
        if(x<=srodek_x && x>=srodek_x-wys && y>=srodek_y && y<=srodek_y+szer) System.out.println("Punkt (" + x +"," + y + ") znajduje sie wewnatrz prostokata");
        else System.out.println("Punkt (" + x +"," + y + ") nie znajduje sie wewnatrz prostokata");
    }

    @Override
    public String toString()
    {
        return super.toString() + "\nLewy górny - (" + srodek_x + ',' + srodek_y + ")" + "\nSzerokość: " + szer + ", " + "Wysokość: " + wys + "\n";
    }

    @Override
    public double pole() {
        return szer*wys;
    }

    @Override
    public double obwod() {
        return 2*szer+2*wys;
    }
}