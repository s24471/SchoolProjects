package com.company;

public class Sosna extends Drzewo{
    public Sosna(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
    }

    @Override
    void zerwijOwoc() throws DrzewoBezOwocoweException {
        throw  new DrzewoBezOwocoweException();
    }
}
