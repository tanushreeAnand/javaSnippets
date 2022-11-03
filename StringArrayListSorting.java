//Java program to sort a Collection of String in ascending and descending order
import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		String str = br.readLine();
		String[] s_arr = str.split(" ");
		
		List<String> list1 = new ArrayList<>(Arrays.asList(s_arr));
		List<String> list2 = new ArrayList<>(list1);
		Collections.sort(list1);
		
		Collections.sort(list2, Collections.reverseOrder() );
		
		System.out.println(list1);
		System.out.println(list2);	
		
	}
}
