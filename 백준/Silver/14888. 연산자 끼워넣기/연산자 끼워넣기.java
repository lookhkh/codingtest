
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static int[] opers;
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.valueOf(tk.nextToken());
		}
		
		opers = new int[4];
		
		tk = new StringTokenizer(br.readLine()," ");
		
		for(int i=0; i<4; i++) {
			opers[i] = Integer.valueOf(tk.nextToken());
		}
		
		dfs(0,new char[n-1]);
		System.out.println(max);
		System.out.println(min);
	}
	private static void dfs(int cur, char[] cs) {

		if(cur == n-1) {
			
			int sum = arr[0];
			for(int i=0; i<cs.length; i++) {
				char next = cs[i];
				if(next == '+') sum+=arr[i+1];
				if(next == '-') sum-=arr[i+1];
				if(next == '*') sum*=arr[i+1];
				if(next == '/') sum/=arr[i+1];
				
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);

		}else {
			
			for(int i=0; i<opers.length; i++) {
				if(opers[i] <= 0) continue;
				opers[i] --;
				cs[cur] = getOper(i); 
				dfs(cur+1,cs);
				opers[i] ++;
			}
			
		}
		
	}
	private static char getOper(int i) {
		if(i == 0) return '+';
		if(i == 1) return '-';
		if(i == 2) return '*';
		return '/';
	}
}
