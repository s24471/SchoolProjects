package com.company;

public class DetektorDymu {
    boolean dym;

    DetektorDymu(boolean dym){
        this.dym=dym;
    }

    void sprawdz() throws Alarm{
        if(dym)
            throw new Alarm();
    }
}
