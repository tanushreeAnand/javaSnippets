//Java program to Reverse a String using swapping of characters in char array
import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		String str = br.readLine();
		int l = str.length();
		char[] arr = new char[l];
		arr = str.toCharArray();
		int start, last;
		for (start = 0, last = l-1; start < last; start++, last-- ){
			char x = arr[start];
			arr[start] = arr[last];
			arr[last] = x;
		}
		// int start = 0, last = l-1;
		// for (int i = 0; i < l/2; i++){
		// 	char x = arr[start];
		// 	arr[start] = arr[last];
		// 	arr[last] = x;
		// 	start++;
		// 	last--;
		// }
		System.out.println(arr);
	}
}
