/**
 *
 *  @author Gocławski Filip S24471
 *
 */

package UTP31;




import java.util.*;

public class Main {

  static List<String> getPricesInPLN(List<String> destinations, double xrate) {
    return ListCreator.collectFrom(destinations)
                       .when((String n)-> n.split("\\s+")[0].equals("WAW"))
                       .mapEvery((String n) -> "to " + n.split("\\s+")[1] + " - price in PLN:\t" + String.valueOf((int)(Integer.valueOf(n.split("\\s+")[2]) * xrate)));
  }

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
    for (String r : result) System.out.println(r);
  }
}
