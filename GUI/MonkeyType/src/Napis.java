import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Napis {
    private List<String> slowa;
    private List<String> oryginalSlowa;
    private StringBuilder wpisanyTekst;
    private StringBuilder oczekiwanyTekst;
    private int index;
    private int indexChar;
    private List<List<Color>> kolory;

    public Napis(List<String> slowa) {
        this.slowa = slowa;
        this.oryginalSlowa = new ArrayList<>(slowa);
        this.wpisanyTekst = new StringBuilder();
        this.oczekiwanyTekst = new StringBuilder();
        this.kolory = new ArrayList<>();
        index = 0;
        indexChar = 0;
        for (String slowo : slowa) {
            List<Color> list = new ArrayList<>();
            for (int i = 0; i < slowo.length(); i++) {
                list.add(Color.GRAY);
            }
            kolory.add(list);
        }
    }

    public void inputChar(char litera) {
        if (litera == ' ') {
            index++;
            indexChar = 0;
            return;
        }
        if (indexChar >= slowa.get(index).length()) {
            slowa.set(index, slowa.get(index) + litera);
            kolory.get(index).add(Color.ORANGE);
            indexChar++;
            return;
        }
        char oczekiwanaLitera = slowa.get(index).charAt(indexChar);

        if (litera == oczekiwanaLitera) {
            kolory.get(index).set(indexChar, Color.GREEN);
        } else {
            if(slowa.get(index).substring(indexChar).contains(String.valueOf(litera))){
                while(slowa.get(index).charAt(indexChar)!=litera){
                    kolory.get(index).set(indexChar++, Color.BLACK);
                }
                kolory.get(index).set(indexChar, Color.GREEN);
            }
            else kolory.get(index).set(indexChar, Color.RED);
        }
        indexChar++;

    }

    public List<List<Color>> getKolory() {
        return kolory;
    }

    public List<String> getNapisy() {
        return slowa;
    }
    public void deleteCharacter(){
        if(indexChar>0){
            if(slowa.get(index).length() != oryginalSlowa.get(index).length()){
                indexChar--;
                StringBuilder tmp = new StringBuilder();
                for (int i = 0; i < slowa.get(index).length()-1; i++) {
                    tmp.append(slowa.get(index).charAt(i));
                }
                slowa.set(index, tmp.toString());
                kolory.get(index).remove(indexChar);
            }else{
                indexChar--;
                kolory.get(index).set(indexChar, Color.GRAY);
            }
        }
        else if (index > 0) {
            index--;
            indexChar = slowa.get(index).length();
            //kolory.get(index).set(indexChar, Color.GRAY);
        }

    }
}
