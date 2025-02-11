package com.company;

public interface Speakable {
    String speak();
    static Speakable maxGlosnosc(Speakable[] tab)
    {
        int max =0;
        for (int i = 1; i < tab.length; i++) {
            if(tab[i].speak().length()>tab[max].speak().length())max =i;
        }
        return tab[max];
    }
}
