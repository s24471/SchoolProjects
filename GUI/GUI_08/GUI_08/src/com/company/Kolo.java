package com.company;

public class Kolo extends Figura implements Obliczenie{
    private int promien;

    public Kolo(int srodek_x, int srodek_y, int promien) {
        super(srodek_x, srodek_y);
        this.promien = promien;
    }

    @Override
    public String fig() {
        return "Kolo";
    }

    @Override
    public void pozycja(int x, int y) {
        if(Math.sqrt(((srodek_x - x)*(srodek_x - x)) + ((srodek_y - y)*(srodek_y - y)))>promien)
            System.out.println("Punkt (" + x +"," + y + ") nie znajduje sie wewnatrz kola");
        else System.out.println("Punkt (" + x +"," + y + ") znajduje sie wewnatrz kola");
    }

    @Override
    public String toString() {
        return super.toString() + "\nSrodek - (" + srodek_x + "," + srodek_y + ")\nPromien - " + promien + "\n";
    }

    @Override
    public double pole() {
        return Math.PI*promien*promien;
    }

    @Override
    public double obwod() {
        return Math.PI*2*promien;
    }
}
