public class Main {

    public static void main(String[] args) {
        Owoc [] owoce=new Owoc[100];
        double wagaOwocow=0;
        Drzewo d=new Drzewo();
        int indexO=0;

        while (wagaOwocow<5000){
            owoce[indexO]=d.zerwijOwoc();
            wagaOwocow+=owoce[indexO].getWeight();
            indexO++;
        }

        int countJ=0,countP=0,countG=0;
        for (int i = 0; i < indexO; i++) {
            if(owoce[i].getName().equals("Jablko")) countJ++;
            else if(owoce[i].getName().equals("Pomarancza")) countP++;
            else countG++;
        }

        System.out.println("Jablka "+countJ);
        System.out.println("Pomarancze "+countP);
        System.out.println("Gruszki "+countG);

        Smartfon m=new Smartfon("Samsung","granat");
        m.kontakty[0]=new Osoba("A","A","123");
        m.kontakty[1]=new Osoba("B","B","234");
        m.kontakty[2]=new Osoba("C","C","456");
        Telefon t[]=new Telefon[3];
        t[0]=new Telefon("Nokia", "czarny");
        t[1]=new Komorka("Xiaomi","biały");
        t[2]=m;

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < 10; j++) {
                if(j%2==0){
                    int rand=(int)(Math.random()*3);
                    t[i].zadzwon(m.kontakty[rand].numer);
                }
                else {
                    String number= String.valueOf((int)(Math.random()*100000));
                    t[i].zadzwon(number);
                }
            }
            System.out.println(t[i].interfejsKomunikacyjny);
            t[i].wyswietlHistoriePolaczen();
        }
    }
}
