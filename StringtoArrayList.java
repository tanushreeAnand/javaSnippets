//Java program to convert a String to ArrayList
import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		String str = br.readLine();
		//way 1
		char[] arr = str.toCharArray();
		List<Character> list = new ArrayList<>();
		for(char c : arr)
			list.add(c);
		System.out.println(list);
		
		//way 2
		String[] s_arr = str.split("");
		List<String> list1 = new ArrayList<>(Arrays.asList(s_arr));
		
		System.out.println(list1);	
	}
}
