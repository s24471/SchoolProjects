/**
 *
 *  @author Gocławski Filip S24471
 *
 */

package UTP21;


import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> { // Uwaga: klasa musi być sparametrtyzowana
    private List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> tmp){
        return new ListCreator<T>(tmp);
    }

    public ListCreator<T> when(Selector sel){
        List<T> a = new ArrayList<>();
        for (T tmp:
             list) {
            if(sel.select(tmp))
                a.add(tmp);
        }
        return new ListCreator<T>(a);
    }
    public List<Integer> mapEvery(Mapper map){
        List<Integer> a = new ArrayList<>();
        for (T tmp:
                list) {
            a.add((Integer)map.map(tmp));
        }
        return a;
    }
}
