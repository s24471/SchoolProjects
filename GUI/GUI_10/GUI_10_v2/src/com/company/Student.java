package com.company;

public class Student extends Osoba {
    int numerGrupy;

    public Student(String nazwisko, int wiek, int numerGrupy) {
        super(nazwisko, wiek);
        this.numerGrupy = numerGrupy;
    }

    @Override
    public int compareTo(Osoba o) {
        if (o instanceof Student) {
            Student s = (Student) o;
            if (this.nazwisko == s.nazwisko) {
                if (this.wiek == s.wiek) {
                    return this.numerGrupy - s.numerGrupy;
                }
                return this.wiek - s.wiek;
            }

            return this.nazwisko.compareTo(s.nazwisko);
        }
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                ", numerGrupy=" + numerGrupy +
                '}';
    }
}
