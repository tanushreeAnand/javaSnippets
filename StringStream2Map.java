import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Main{
    public static void main(String[] args){  
        Stream<String[]>
            Ss1 = Stream.of(new String[][] { { "TOI", "Times of India" },
                                           { "T", "Telegraph" },
                                           { "TOI", "TGIF" },
                                           { "TOI", "Times Group" } });
  
        // Get Map from 2D Stream String array using toMap() method
        LinkedHashMap<String, String>
            map2 = Ss1.collect(Collectors.toMap(
                     p -> p[0], p -> p[1], (s, a) -> s + ", " + a, LinkedHashMap::new));
  
        System.out.println("Map:" + map2);
        //output:
        //Map:{TOI=Times of India, TGIF, Times Group, T=Telegraph}
    }
}
