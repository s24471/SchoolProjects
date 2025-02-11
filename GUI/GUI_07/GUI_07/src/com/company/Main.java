package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
//        Spiewak s1 = new Spiewak("Dietrich"){
//            @Override
//            protected String spiewaj() {
//                return "oooooooooooo";
//            }
//        };
//
//        Spiewak s2 = new Spiewak("Piaf") {
//            @Override
//            protected String spiewaj() {
//                return "a4iBBiii";
//            }
//        };
//
//        Spiewak s3 = new Spiewak("Adele"){
//            @Override
//            protected String spiewaj() {
//                return "aAa";
//            }
//        };
//
//        Spiewak sp[] = {s1, s2, s3};
//
//        for (Spiewak s : sp) {
//            System.out.println(s);
//            System.out.println(Spiewak.glosnosc(s));
//
//        }
//        System.out.println("\n" + Spiewak.najglosniej(sp));
//        (3) Houston: a4iBBiii
//            (4) Carrey: oaooooooooooo
//            (1) Darrey: eeae
//            (2) Darrey: bebe
//            (5) Madonna: aAa
        List<Spiewak> list = new ArrayList<>();
        list.add(new Spiewak("Darrey") {
            @Override
            protected String spiewaj() {
                return "eeae";
            }
        });
        list.add(new Spiewak("Darrey") {
            @Override
            protected String spiewaj() {
                return "bebe";
            }
        });
        list.add(new Spiewak("Houston") {
            @Override
            protected String spiewaj() {
                return "a4iBBiii";
            }
        });
        list.add(new Spiewak("Carrey") {
            @Override
            protected String spiewaj() {
                return "oaooooooooooo";
            }
        });
        list.add(new Spiewak("Madonna") {
            @Override
            protected String spiewaj() {
                return "aAa";
            }
        });

        Collections.sort(list);
        System.out.println(list);
    }
}