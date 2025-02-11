package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Figura fig[] = new Figura[2];
//        fig[0] = new Kolo(10, 10, 5);                    // położenie koła = srodek = (10,10), promień = 5
//        fig[1] = new Prostokat(20, 20, 15, 10);    // położenie prostokąta = lewy górny wierzchołek = (20,20), szerokość = 15, wysokość = 10
//
//        // polimorficzne wywołanie metody toString() z klas Kolo/Prostokat,
//        // a nie z klasy Figura
//        for (Figura f : fig)              // pętla for-each
//            System.out.println(f);    // System.out.println(f.toString());
//
//        fig[0].pozycja(12, 12);
//        fig[1].pozycja(25, 30);
//
//        Figura p2 = new Prostokat2(20, 20, 10, 5, '*');       // prostokąt rozmiaru 10 x 5 będzie "rysowany" na konsoli za pomocą znaku '*'
//        ((Prostokat2)p2).rysuj();      //p2 jest w deklaracji jako obiekt Figura a nie Prostokat2                                    // Wyjaśnić dlaczego p2.rysuj() nie działa?
//
//        Kolo2 k2 = new Kolo2(15, 20, 5);
//
//        k2.przesunDo(50, 40);    // przesunięcie środka koła do punktu (50, 40)
//        System.out.println(k2);
//
//        k2.powrot();                    // powrót do poprzedniej pozycji (bezpośrednio przed przesunięciem) środka koła
//        System.out.println(k2);

        List<Figura> list = new ArrayList<>();
        list.add(new Prostokat(1,1,4,9));
        list.add(new Kolo(1,1,5));
        list.add(new Prostokat(2,2,6,6));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }
}
