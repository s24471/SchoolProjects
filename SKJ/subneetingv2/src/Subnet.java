
public class Subnet {
    String name;
    int nr;
    int[] nid;
    int[] ba;
    int[] maska;

    public Subnet(String name, String nr1) {
        this.name = name;
        this.nr = Integer.parseInt(nr1);
        nr+=2;
        int i = 1;
        while(i<nr){
            i*=2;
        }
        nr = i;


        maska = new int[4];
        maska[0] = 0;
        maska[1] = 0;
        maska[2] = 0;
        maska[3] = 0;
        int ip = Main.ipv4.get(nr);
        int ok;
        if(nr<=128)ok=4;
        else if(nr<=32768)ok=3;
        else if(nr<=16777216)ok = 2;
        else ok = 1;
        for (int j = 0; j < ok-1; j++) {
            maska[j] = 255;
        }
        maska[ok-1] = ip;
    }

    public void setNid(int[] nid) {
        this.nid = new int[4];
        for (int i = 0; i < 4; i++) {
            this.nid[i] = nid[i];
        }
    }



    public void setBa(int[] ba) {
        this.ba = new int[4];
        for (int i = 0; i < 4; i++) {
            this.ba[i] = ba[i];
        }
        decrease();
    }

    public void decrease(){
        ba[3]--;
        for (int i = 3; i > 0; i--) {
            if(ba[i]<0){
                ba[i-1]--;
                ba[i]=255;
            }
        }
    }
    @Override
    public String toString() {
        System.out.println("Name: " + name);
        System.out.println("Rozmiar: " + nr);
        System.out.println("nid/adres podsieci: " + nid[0] +"."+nid[1]+"."+nid[2]+"."+nid[3]);
        System.out.println("ba/adres rozgłoszeniowy: " + ba[0]+"."+ba[1]+"."+ba[2]+"."+ba[3]);
        System.out.println("MASKA: " + maska[0]+"."+maska[1]+"."+maska[2]+"."+maska[3] +"/"+Main.cidr.get(nr));
        return "";
    }
}