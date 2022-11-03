//Java program to sort a Collection of StringBuffer in ascending order
import java.io.*;
import java.util.*;
class StringBufferCustomComparator implements Comparator<StringBuffer>{
	public int compare(StringBuffer sb1, StringBuffer sb2){
		return sb1.toString().compareTo(sb2.toString());
	}
}
class Main {
	static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	public static void main(String args[]) throws IOException {
		String str  = br.readLine();
		int n = Integer.parseInt(str);
		
		ArrayList<StringBuffer> st = new ArrayList<StringBuffer>();
		while(n > 0){
			str = br.readLine();	
			st.add(new StringBuffer(str));
			n--;
		}
		//Set<StringBuffer> set = new TreeSet<StringBuffer>(st); --> Runtime exception because of Comparable 
		Set<StringBuffer> set = new TreeSet<StringBuffer>(new StringBufferCustomComparator());
		set.addAll(st);
		System.out.println(set);
		
		//TreeSet<Object> res = (TreeSet<Object>)set.descendingSet();
		//NavigableSet<StringBuffer> nset = set.descendingSet();
		//Collections.sort(set, Collections.reverseOrder());
			
	}
}
