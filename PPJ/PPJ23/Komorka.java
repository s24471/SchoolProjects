public class Komorka extends Telefon{
    String historia[];
    int iloscPol=0;

    public Komorka(String iK, String color){
        super(iK,color);
        historia=new String[10];
    }

    @Override
    public void zadzwon(String numer){
        super.zadzwon(numer);
        for (int i = historia.length-1; i >0 ; i--) {
            historia[i]=historia[i-1];
        }
        historia[0]=numer;
        iloscPol++;
    }

    @Override
    public void wyswietlHistoriePolaczen(){
        int indexMax=0;
        if(iloscPol<10){
            indexMax=iloscPol;
        }else indexMax=historia.length;

        for (int i = 0; i < indexMax; i++) {
            System.out.println(historia[i]);
        }
    }
}
