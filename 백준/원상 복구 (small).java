//https://www.acmicpc.net/problem/22858


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main22858 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk;
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.valueOf(tk.nextToken());
		int k = Integer.valueOf(tk.nextToken());
		
		tk = new StringTokenizer(br.readLine()," ");
		
		int[] current = new int[n];
		
		for(int i=0; i<n; i++) {
			current[i] = Integer.valueOf(tk.nextToken());
		}
		
		int[] d = new int[n];
		tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<n; i++) {
			d[i] = Integer.valueOf(tk.nextToken());
		}
		
		
		for(int i=0; i<k; i++) {
			
			int[] copy = new int[n];

			for(int j=0; j<current.length; j++) {
				
				copy[d[j]-1] = current[j]; 

			}
		
			current = copy;
		}
		StringBuilder b= new StringBuilder();
		for(int t : current) {
			b.append(t+" ");
		}
		System.out.println(b.toString());
		
		
	}
}
