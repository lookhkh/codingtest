//https://www.acmicpc.net/problem/2805

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main162022 {
	
	 static long N;
	 static long M;
	 static long[] arr;
	 
	 public static void main(String[] args) throws NumberFormatException, IOException {
         
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer tk = new StringTokenizer(br.readLine()," ");
	        
	         N = Long.valueOf(tk.nextToken());
	         M = Long.valueOf(tk.nextToken());
	        
	         arr = new long[(int)N];
	         tk = new StringTokenizer(br.readLine()," ");
	        for(int i=0; i<N; i++) {
	            arr[i] = Integer.valueOf(tk.nextToken());
	        }
	        
	        Arrays.sort(arr);
	        
	        long max = arr[arr.length-1];

	        int left = 0;
	        int right = 2_000_000_000;
	        int mid = 0;
	        
	        int answer = 0;
	        
	        while(left < right) {
	        	
	        	mid = (int)( left+ right) / 2;
	        	long result = check(mid);
	        	
	        	if(result>=M) {
	        		left = mid+1;
	        		answer = mid;
	        	}else {
	        		right = mid-1;
	        	}
	        	
	        }
	        
	        System.out.println(answer);
	 }

	private static long check(long value) {

		long result = 0;
		
		for(int i=0; i<arr.length; i++) {
			long next = arr[i];
			if(next >= value) {
				result+= next-value;
			}
			
		}
		
		
		return result;
	}
	        
}