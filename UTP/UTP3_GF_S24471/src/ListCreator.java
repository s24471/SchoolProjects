/**
 *
 *  @author Gocławski Filip S24471
 *
 */

package UTP31;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T> { // Uwaga: klasa musi być sparametrtyzowana
    private List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public static <T> ListCreator<T> collectFrom(List<T> tmp){
        return new ListCreator<T>(tmp);
    }

    public ListCreator<T> when(Predicate<T> sel){
        List<T> a = new ArrayList<>();
        for (T tmp:
             list) {
            if(sel.test(tmp))
                a.add(tmp);
        }
        return new ListCreator<T>(a);
    }
    public List<T> mapEvery(Function<T, T> map){
        List<T> a = new ArrayList<>();
        for (T tmp:
                list) {
            a.add(map.apply(tmp));
        }
        return a;
    }
}
