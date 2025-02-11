package com.company;

import java.util.Iterator;
class IterNap implements Iterable<Character> {

    protected char [] arr;
    protected int start;
    protected int krok;
    protected int len;
    public IterNap(String n) {
        len = n.length();
        this.arr = n.toCharArray();
        start = 0;
        krok = 1;
    }

    public void ustawPoczatek(int start) {
        this.start =start;
    }

    public void ustawKrok(int krok) {
        this.krok=krok;
    }

    public Iterator<Character> iterator() {
            return new Iterator<Character>(){

            private int index=start;

            public boolean hasNext() {
                return index+krok<=len;
            }

            public Character next() {
                index += krok;
                return arr[index-krok];
            }
        };
    }
}
