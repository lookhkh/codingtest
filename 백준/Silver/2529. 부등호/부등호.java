import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static long min = Long.MAX_VALUE;
	static String minStr = "";
	static long max = Long.MIN_VALUE;
	static String maxStr = "";
	static List<String> opers = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<n; i++) opers.add(tk.nextToken());
		
		dfs(n,0,new boolean[10],new int[n+1]);
		
		System.out.println(maxStr);
		System.out.println(minStr);
	}
	
	private static void dfs(int n, int idx, boolean[] check, int[] arr) {
				
		if(n+1 == idx) {
			String sum = "";
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != -1) sum += arr[i];
			}
			
			long convertSum = Long.valueOf(sum);

			if(convertSum > max) {
				max = convertSum;
				maxStr = sum;
			}
			
			if(convertSum < min) {
				min = convertSum;
				minStr = sum;
			}
			
		
		}else {
			
			for(int i=0; i<10; i++) {
				
				if(check[i]) continue;
				
				if(idx-1 >= 0 && idx-1 < opers.size()) {
					String nextOper = opers.get(idx-1);
					int previous = arr[idx-1];
					
					if(nextOper.equals("<")) {
						if(previous > i) continue;
					}else if(nextOper.equals(">")) {
						if(previous < i) continue;
					}
					
				}
				
				check[i] = true;
				arr[idx] = i;
				dfs(n,idx+1,check,arr);
				check[i] = false;
				arr[idx] = -1;
			}
			
		}
		
	}

}
