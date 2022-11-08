import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;

class Main{
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // HashMap operations
   
    public static void main(String[] args) throws IOException{
        // read N key-value pairs from user input
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for (int i=0;i < n; i++){
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            map.put(key, val);
        }
       //sort
      //  HashMap<Integer, Integer> temp = sortMap();
      HashMap<Integer, Integer> temp  = map.entrySet().stream()
                        .sorted((m1, m2)-> m1.getKey().compareTo(m2.getKey()))
                        .collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2)-> a1+a2, LinkedHashMap::new));
        // alternatives to print - > iterator,forEach,  Iterator.forEachRemaining(), Stream.of, toString
        // way 1 - forEach
        for(Map.Entry<Integer, Integer> entry: temp.entrySet()){
            int k = entry.getKey();
            int v = entry.getValue();
            System.out.println(k + ": "+ v);
        }
             
        //way 2 - toString
        System.out.println(temp.toString());
        
        //way3 - iterator
        Iterator<Map.Entry<Integer, Integer>> it = temp.entrySet().iterator();
        while (it.hasNext())
            System.out.println(it.next());
            
        //way 4 - 
        temp.entrySet()
            .iterator()
            .forEachRemaining(System.out::println);
            
        //way 5 -
        Stream.of(temp.entrySet().toArray())
            .forEach(System.out::println);\
          
        //way 6 -
          temp.entrySet()
            .stream()
            .forEach(System.out::println);
        
    }
}
