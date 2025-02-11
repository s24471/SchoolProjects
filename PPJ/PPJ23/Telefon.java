public class Telefon {
    String interfejsKomunikacyjny;
    String color;

    public Telefon(String iK, String color){
        interfejsKomunikacyjny=iK;
        this.color=color;
    }
    public void zadzwon(String numer){
        System.out.println(numer);
    }

    public void wyswietlHistoriePolaczen(){
        System.out.println("brak historii");
    }
}
