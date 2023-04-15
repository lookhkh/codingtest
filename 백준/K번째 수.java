//https://www.acmicpc.net/problem/1300

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	 static long n;
	 static long m;
	 
	 public static void main(String[] args) throws NumberFormatException, IOException {
         
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.valueOf(br.readLine());
		 m = Integer.valueOf(br.readLine());
		 
		 long left = 0;
		 long right = Long.MAX_VALUE;
		 
		 long answer = Integer.MAX_VALUE;
		 while(left<=right) {
			 
			 long mid = (left+right) / 2;
			 long nums = getCount(mid);
			 
			 if(nums >= m) {
				 right = mid -1;
				 answer = Math.min(answer, mid);
			 }else {
				 left=mid+1;
			 }
			 
			 
		 }
		 
		System.out.println(answer);
	 
	 }

	private static long getCount(long mid) {

		long result = 0;
		for(int i=1; i<=mid; i++) {
			
			result+= Math.min( mid/i , n );
			
			
		}
		
		
		return result;
	}
}