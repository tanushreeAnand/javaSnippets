//Java program to sort a Collection of StringBuffer in ascending order
import java.io.*;
import java.util.*;

class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		String str = "geeksss@forss@geekss";
		String[] arrOfStr = str.split("s");
		int i=0;
        for (String a : arrOfStr){
            System.out.printf("%d"+ a+"\n", i);
			i++;
		}
			
    }
}
// output
// 0geek
// 1
// 2
// 3@for
// 4
// 5@geek
