package com.company;

public class Main {

    public static void main(String[] args) {
	    Drzewo las[]={new Sliwa(false,20,"A"),
        new Sosna(true,30,"B")};

//        for (int i = 0; i < las.length; i++) {
//            System.out.println(las[i]);
//            try {
//                las[i].zerwijOwoc();
//            }catch (DrzewoBezOwocoweException e){
//                e.printStackTrace();
//            }
//        }

        DetektorDymu d=new DetektorDymu(true);
        try {
            d.sprawdz();
        } catch (Alarm alarm) {
            alarm.printStackTrace();
        }
    }
}
