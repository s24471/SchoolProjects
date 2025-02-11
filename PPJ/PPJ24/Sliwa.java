package com.company;

public class Sliwa extends Drzewo{
    public Sliwa(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa) {
        super(wiecznieZielone, wysokosc, przekrojDrzewa);
    }


    @Override
    void zerwijOwoc() throws DrzewoBezOwocoweException {
        System.out.println("zerwano owoc");
    }
}
