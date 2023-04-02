//https://www.acmicpc.net/problem/3079

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] tables;
	static long max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		tables = new int[n];
		
		for(int i = 0; i < n; i++) {
			tables[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, tables[i]);
		}
		
		long left = 1;
		long right = 1_000_000_000 * (long)Math.pow(10, 9);
		long mid = 0;
		while(left < right) {
			
			mid = (left+right)/2;
			long tempSum = 0;
			
			for(int table : tables) {
				
				tempSum += mid/table;
				if(tempSum >= m) break;
				
			}
			
			if(tempSum >= m) {
				right = mid;
			}else {
				left = mid+1;
			}
			
		}
		
		System.out.println(left);
		
		
	}
}
