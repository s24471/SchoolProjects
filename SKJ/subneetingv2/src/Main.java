import java.util.*;
import java.util.function.ToIntFunction;


class Main {
    //================DO ZMIENIENIA ===========================
    boolean odNajwiekszej = true; // Jezeli od najwiekszej to true jak nie to false
    boolean odA = true; //A-Z true Z-A false
    String ipAdress = "11.104.172.43"; // IP
    int maska = 16; // to po "/" w masce
    String all = " (F,2541), (P,18712), (G,490), (L,582), (Y,79), (D,3988), (M,755), (I,464),\n" +
            "(C,451).\n"; // wszystkie podscieci
    // np: String all = " (K,110), (Z,52), (H,84), (J,117), (P,26), (O,11), (B,55), (D,460), (F,55)";

    //==================PROGRAM================

    //String subnetMask = ""; // <- niezbyt potrzebne
    static Map<Integer, Integer> ipv4 = new HashMap<>();
    static Map<Integer, Integer> cidr = new HashMap<>();
    int[]  baza;
    public static void main(String[] args) {
        new Main();
    }
    public Main(){

        int[] ipA = Arrays.stream(ipAdress.split("\\.")).mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String value) {
                return Integer.parseInt(value);
            }
        }).toArray();
        baza = new int[4];
        Map<Integer, Integer> dzielniki = new HashMap<>();
        dzielniki.put(17, 128);
        dzielniki.put(18, 64);
        dzielniki.put(19, 32);
        dzielniki.put(20, 16);
        dzielniki.put(21, 8);
        dzielniki.put(22, 4);
        dzielniki.put(23, 2);
        dzielniki.put(24, 1);

        dzielniki.put(25, 128);
        dzielniki.put(26, 64);
        dzielniki.put(27, 32);
        dzielniki.put(28, 16);
        dzielniki.put(29, 8);
        dzielniki.put(30, 4);
        dzielniki.put(31, 2);
        dzielniki.put(32, 1);

        dzielniki.put(9, 128);
        dzielniki.put(10, 64);
        dzielniki.put(11, 32);
        dzielniki.put(12, 16);
        dzielniki.put(13, 8);
        dzielniki.put(14, 4);
        dzielniki.put(15, 2);
        dzielniki.put(16, 1);

        dzielniki.put(1, 128);
        dzielniki.put(2, 64);
        dzielniki.put(3, 32);
        dzielniki.put(4, 16);
        dzielniki.put(5, 8);
        dzielniki.put(6, 4);
        dzielniki.put(7, 2);
        dzielniki.put(8, 1);


        int pow = 1;
        int pow2 = 1;
        int ipv = 255;
        for(int i=0; i<31; i++){
            ipv4.put(pow, ipv);
            cidr.put(pow, 32-i);
            ipv-=pow2;
            pow2*=2;
            pow*=2;
            if(ipv == 0){
                pow2=1;
                ipv = 255;
            }
        }
        /*pow = 1;
        for (int i = 0; i < 31; i++) {
            System.out.println(pow +" " + ipv4.get(pow));
            pow*=2;
        }*/

        int koncowkaMaski = dzielniki.get(maska);
        //int octet = koncowkaMaski/8!=koncowkaMaski/8*8 ?koncowkaMaski/8+1 :koncowkaMaski/8;
        int octet = (int)Math.ceil(((double) maska /8));
        System.out.println("octet = " + octet);
        int zwykla = ipA[octet - 1];
        System.out.println(maska);
        System.out.println(koncowkaMaski);
        int temp = zwykla / koncowkaMaski;

        while (!(temp * koncowkaMaski <= zwykla)){
            temp--;
        }
        ArrayList<Subnet> subnets =new ArrayList<>();
        all = all.replace("(", "");
        all = all.replace(")", "");
        all = all.replace(" ", "");
        all = all.replace(".", "");
        all = all.replace("\n", "");
        String[] allSplited = all.split(",");
        for (int i = 0; i < allSplited.length; i+=2) {
            subnets.add(new Subnet(allSplited[i], allSplited[i+1]));
        }
        subnets.sort(new Comparator<Subnet>() {
            @Override
            public int compare(Subnet a, Subnet b) {
                if(a.nr != b.nr){
                    if(!odNajwiekszej){
                        return a.nr-b.nr;
                    }else{
                        return b.nr-a.nr;
                    }
                }else{
                    if(odA){
                        return a.name.compareTo(b.name);
                    }
                    return b.name.compareTo(a.name);
                }
            }
        });

        int a = temp  * koncowkaMaski;
        System.arraycopy(ipA, 0, baza, 0, 4);
        baza[octet-1] = a;
        for (int i = 3; i >=octet ; i--) {
            baza[i]=0;
        }

        soutBaza();
        int sum =0;
        for (Subnet subnet : subnets) {

            subnet.setNid(baza);
            incremate(subnet.nr);
            subnet.setBa(baza);
            System.out.println(subnet);
            sum+=subnet.nr;
        }
        System.out.println("Liczba adresow wszystkich podsieci po podziale to " + sum);
        boolean check = true;

        for (int i = 0; i < ipA.length; i++) {
            if (ipA[i] != subnets.get(0).nid[i]) {
                check = false;
                break;
            }
        }
        System.out.println("Czy podany adres ip sieci źródłowej jest adresem sieci? " + check);
    }

    public void incremate(int n){
        baza[3]+=n;
        for (int i = 3; i >= 0; i--) {
            if(baza[i]>255){
                baza[i-1]+=baza[i]/255;
                baza[i]=0;
            }
        }
    }
    public void soutBaza(){
        System.out.println( baza[0] +"."+ baza[1] +"."+baza[2] +"." + baza[3]);
    }
}