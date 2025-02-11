package com.company;

public class Corn {
    private int cornCount;

    public Corn(int cornCount){
        this.cornCount=cornCount;
    }

    public Popcorn[] makePopcorn(){
        Popcorn[] popcorns=new Popcorn[(int) (Math.random()
                *cornCount)];
        for (int i = 0; i < popcorns.length; i++) {
            popcorns[i]=new Popcorn();
        }
        return popcorns;
    }
}
