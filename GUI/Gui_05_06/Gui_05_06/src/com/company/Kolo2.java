package com.company;

public class Kolo2 extends Kolo implements Transformacja{
    private int stary_x;
    private int stary_y;


    public Kolo2(int srodek_x, int srodek_y, int promien) {
        super(srodek_x, srodek_y, promien);
    }

    @Override
    public void przesunDo(int x, int y) {
        stary_x = srodek_x;
        stary_y = srodek_y;
        srodek_x = x;
        srodek_y = y;
    }

    @Override
    public void powrot() {
        srodek_x = stary_x;
        srodek_y = stary_y;
    }
}
