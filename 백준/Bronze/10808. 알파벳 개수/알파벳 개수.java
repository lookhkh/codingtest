import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String next= in.next();
		int[] arr = new int[26];
		
		for(int i=0; i<next.length(); i++) {
			char n = next.charAt(i);
			arr[n-'a']+=1;
		}
		
		StringBuilder b= new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			b.append(arr[i]+" ");
		}
		
		System.out.println(b.toString().substring(0,b.length()-1));
	}
}