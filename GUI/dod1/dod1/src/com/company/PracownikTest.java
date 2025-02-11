package com.company;

class PracownikTest {
    static public Pracownik najlepiejZarabiajacy(Pracownik[] arr) {
        int max =0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].obliczPensje()>arr[max].obliczPensje())max=i;
        }
        return arr[max];
    }
    static public Osoba najmlodsza(Osoba[] arr){
        int min=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i].getWiek()<arr[min].getWiek()) min=i;
        }
        return arr[min];
    }
    public static void main(String[] args) {
        Osoba nowicka = new Pracownik("Nowicka", 20, Stanowisko.Programista, 2); // nazwisko = Nowak, wiek = 20, stanowisko = Programista, staż = 2 lata
        Pracownik kowal = new Pracownik("Kowal", 30, Stanowisko.Tester, 3);
        Kierownik kowalska = new Kierownik("Kowalska", 25, Stanowisko.Projektant, 4, "Grafika"); // kierownik działu Grafika
        // tablica obiektów typu Osoba zawierajacą osobę oraz pracowników
        Osoba[] osoby = {new Osoba("Nowak", 21), nowicka, kowal, kowalska}; // osoba Nowak z wiekiem 21
        // tablica obiektów typu Pracownik zawierajacą pracownika, kierownika
        Pracownik[] pracownicy = {kowal, kowalska};
        // Odpowiedzieć na pytania:
        // Jakie metody można wywołać na rzecz obiektu nowicka, dlaczego?
        // Co należy zrobić, żeby możliwe były wywołania metod z klasy Pracownik na rzecz obiektu nowicka?
        for (Osoba o : osoby)
            System.out.println(o + "\n");
        System.out.println("Najlepiej zarabiający pracownik: \n" + najlepiejZarabiajacy(pracownicy) + "\n");
        System.out.println("Najmłodsza osoba (wiekiem): \n" + najmlodsza(osoby));
    }
// Po uzupełnieniu całego programu odpowiedzieć na pytanie:
    // Które metody są wywoływane polimorficznie?
}