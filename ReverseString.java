import java.io.*;
import java.util.*;
class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		// Your code goes here
		
		//Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer(br.readLine());
		sb.reverse();
		System.out.println(sb);
	}
}
