package com.company;
public class TestGame {

    public static void main(String[] args) {
        Player p1 = new Player("ppj");                                            // tworzenie gracza ze swoim identyfikatorem
        Player p2 = new Player("gui");

        Referee ref = new Referee(10, new Player[]{p1, p2});                       // arbiter ustala czas gry (w sekundach), "rejestruje" tablicę graczy

        ref.startGame();                                                          // arbiter startuje swój wątek: mierzy czas oraz daje sygnał startu graczom

        try {
            ref.join();                                                           // czekamy, aż wątek arbitra zakończy swoją pracę, tzn. po upływie określonego czasu przerywa pracę wątków wszystkich graczy

            // join() jest metodą z klasy Thread

        } catch (InterruptedException exc) {

            exc.printStackTrace();

        }

        ref.result();                                                              // arbiter ogłasza wynik gry

    }
}

