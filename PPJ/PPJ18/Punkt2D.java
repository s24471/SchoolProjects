package com.company;

public class Punkt2D {
    int x,y;

    public int[] get(){
        int[] tab={x,y,1};
        return tab;
    }

    public void set(int [] el){
        x=el[0];
        y=el[1];
    }
}
