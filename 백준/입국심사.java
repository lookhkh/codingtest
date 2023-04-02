//https://www.acmicpc.net/problem/3079

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2616 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] train = new int[n + 1];
        int[] sum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<train.length; i++) {
        	train[i] = Integer.valueOf(st.nextToken());
        }
        
        for(int i=0; i< train.length; i++) {
        	if(i == 0) sum[i] = train[i];
        	else sum[i] = train[i]+sum[i-1];
        }
      
        int max = Integer.parseInt(br.readLine());

        int[][] dp = new int[4][n+1];
        
        
        for(int i=1; i<4; i++) {
        	
        	for(int j= i * max; j<train.length; j++) {
        		
        		dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-max]+sum[j]-sum[j-max]);
        		
        	}
        	
        }

        System.out.println(dp[3][train.length-1]);
        
	}
}