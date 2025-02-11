public class Spawacz extends Osoba{
    private int stazPracy;

    public Spawacz(String imie, int stazPracy){
        super(imie);
        this.stazPracy=stazPracy;
    }

    @Override
    public String wyswietl(){
       return super.wyswietl()+" staż pracy:"+stazPracy;
    }
}
