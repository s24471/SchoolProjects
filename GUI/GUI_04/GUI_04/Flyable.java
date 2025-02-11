package com.company;

public interface Flyable {
    String drive();
    double distance();
    static Flyable minOdleglosc(Flyable[] tab)
    {
        int min =0;
        for (int i = 1; i < tab.length; i++) {
            if(tab[i].distance()<tab[min].distance())min =i;
        }
        return tab[min];
    }
}
