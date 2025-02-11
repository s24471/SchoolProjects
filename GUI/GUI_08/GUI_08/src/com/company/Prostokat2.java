package com.company;

public class Prostokat2 extends Prostokat implements Rysowanie {
    private char znak;
    public Prostokat2(int srodek_x, int srodek_y, int szer, int wys, char znak) {
        super(srodek_x, srodek_y, szer, wys);
        this.znak = znak;
    }

    @Override
    public void rysuj() {
        for (int i = 0; i < wys; i++) {
            for (int j = 0; j < szer; j++) {
                System.out.print(znak);
            }
            System.out.println();
        }
    }
}
