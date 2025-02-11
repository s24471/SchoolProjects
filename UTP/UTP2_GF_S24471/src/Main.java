/**
 *
 *  @author Gocławski Filip S24471
 *
 */

package UTP21;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);;

    List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv" );
    List<Double> src3 = Arrays.asList(111.111, 20.20, 333.333);
    System.out.println(test1(src1));
    System.out.println(test2(src2));
    System.out.println(test3(src3));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector<Integer> sel= new Selector<Integer>() {
      @Override
      public boolean select(Integer n) {
        return n<10;
      }
    };/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */
    Mapper<Integer, Integer> map = new Mapper<Integer, Integer>() {
      @Override
      public Integer map(Integer d) {
          return d+10;
      }
    };
    /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  new ListCreator<Integer>(src).collectFrom(src).when(sel).mapEvery(map);
  }


  public List<Integer> test2(List<String> src) {
    Selector<String> sel= new Selector<String>() {
      @Override
      public boolean select(String n) {
        return n.length()>3;
      }
    };
/*<-- definicja selektora; bez lambda-wyrażeń; nazwa zmiennej sel */

    Mapper<Integer, String> map = new Mapper<Integer, String>() {
      @Override
      public Integer map(String string) {
        return string.length()+10;
      }
    };
/*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */

    return
/*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */
            new ListCreator<String>(src).collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test3(List<Double> src) {
    Selector<Double> sel = d-> d > 100;
    Mapper<String,Double> map =  new Mapper<String, Double>(){
      @Override
      public String map(Double aDouble) {
        return "L"+aDouble;
      }
    };
    /*<-- definicja mappera; bez lambda-wyrażeń; nazwa zmiennej map */
    return   /*<-- zwrot wyniku
      uzyskanego przez wywołanie statycznej metody klasy ListCreator:
     */  new ListCreator<Double>(src).collectFrom(src).when(sel).mapEvery(map);
  }



  public static void main(String[] args) {
    new Main();
  }
}
