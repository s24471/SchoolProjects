public class Drzewo {
    private boolean wiecznieZielone;
    private int wysokosc;
    private String rzekrojDrzewa;

    public Drzewo(boolean wiecznieZielone, int wysokosc, String przekrojDrzewa){
        this.rzekrojDrzewa=przekrojDrzewa;
        this.wiecznieZielone=wiecznieZielone;
        this.wysokosc=wysokosc;
    }

    @Override
    public String toString(){
        return rzekrojDrzewa+" "+wysokosc+" "+wiecznieZielone;
    }
}
