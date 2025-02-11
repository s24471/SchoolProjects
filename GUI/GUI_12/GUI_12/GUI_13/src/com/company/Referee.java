package com.company;


class Referee extends Thread {

    private int time;
    private int curr;
    private Player[] pl;

    public Referee(int time, Player[] pl) {
        this.time = time;
        this.pl = pl;
        curr = 1;
    }

    void startGame() {

        // start wątku arbitra
        this.start();

        for (int i = 0; i < pl.length; i++) {
            pl[i].start();
        }

    }

    // praca wątku arbitra
    public void run() {
        while (curr <= time) {
            System.out.println();
            System.out.println("Czas: " + curr++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < pl.length; i++) {
            pl[i].interrupt();
        }
    }


    void result() {
        int max = 0;
        for (int i = 0; i < pl.length; i++) {
            if (pl[max].getSuma() < pl[i].getSuma()) max = i;
            System.out.println("wynik " + pl[i].getName() + ": " + pl[i].getSuma());
        }
        System.out.println("Wygral: " + pl[max].getName() + "!");
    }

}


