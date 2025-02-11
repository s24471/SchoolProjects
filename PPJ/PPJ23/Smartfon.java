public class Smartfon extends Komorka {
    Osoba[] kontakty;
    int iloscKontaktow=0;
    public Smartfon(String iK, String color){
        super(iK, color);
        kontakty=new Osoba[100];
    }


    @Override
    public void wyswietlHistoriePolaczen(){
        int indexMax=0;
        if(iloscPol<10){
            indexMax=iloscPol;
        }else indexMax=historia.length;

        for (int i = 0; i < indexMax; i++) {
            int id=getIDKontakt(historia[i]);
            if(id!=-1)
                System.out.print(kontakty[id].imie+" "+kontakty[id].nazwisko+" ");
            System.out.println(historia[i]);
        }
    }

    private int getIDKontakt(String numer){
        for (int i = 0; i < iloscKontaktow; i++) {
            if(kontakty[i].numer.equals(numer))
                return i;
        }
        return -1;
    }

}
