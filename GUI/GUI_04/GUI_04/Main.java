package com.company;

public class Main {

    public static void main(String[] args) {
        Flyable[] f = new Flyable[4];
        Speakable[] s = new Speakable[2];
        f[0] = new UFO();
        f[1] = new Bird();
        f[2] = new Plane();
        f[3] = new Virus();

        s[0] = new Bird();
        s[1] = new UFO();

        System.out.println(f[0].distance());
        System.out.println(f[0].drive());
        System.out.println(((Speakable)f[0]).speak());

        System.out.println(f[1].distance());
        System.out.println(f[1].drive());
        System.out.println(((Speakable)f[1]).speak());

        System.out.println(f[2].distance());
        System.out.println(f[2].drive());

        System.out.println(f[3].distance());
        System.out.println(f[3].drive());

        System.out.println(((Flyable)s[0]).drive());
        System.out.println(((Flyable)s[0]).distance());
        System.out.println(s[0].speak());

        System.out.println(((Flyable)s[1]).drive());
        System.out.println(((Flyable)s[1]).distance());
        System.out.println(s[1].speak());


        System.out.println(Speakable.maxGlosnosc(s).speak());
        System.out.println(Flyable.minOdleglosc(f).distance());
    }
}
