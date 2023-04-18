//https://www.acmicpc.net/problem/1823

package b0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main1823 {

    static int n;
    static int[] arr;   
    static int[][] dp; // i에서 j범위의 벼가 남았을 때의 최대 가치

	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n+1][n+1];
        
        for(int[] d : dp) {
        	Arrays.fill(d, -1);
        }

        System.out.println(findDP(1, n));
       
    }

	private static int findDP(int start, int end) {
		
		if(start > end) return 0;
		
		if(dp[start][end] != -1 ) return dp[start][end];
		
		int cnt = arr.length - (end - start+1);
		
		return dp[start][end] = Math.max(findDP(start+1,end)+cnt * arr[start], findDP(start,end-1) + cnt*arr[end]);
	}
}