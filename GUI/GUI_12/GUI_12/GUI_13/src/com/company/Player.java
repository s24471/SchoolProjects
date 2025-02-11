package com.company;

public class Player extends Thread {
    public int suma;

    public Player(String nazwa) {
        super(nazwa);
        suma = 0;
    }

    // praca wątku gracza
    public void run() {
        while (true) {
            int x = (int) (Math.random() * 100);
            System.out.println(this.getName() + ": " + x);
            suma += x;
            try {
                Thread.sleep((int) (Math.random() * 2000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public int getSuma() {
        return suma;
    }
}
