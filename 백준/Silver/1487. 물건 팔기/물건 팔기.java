import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] prices;
	static int[] costs;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		prices = new int[n];
		costs = new int[n];

		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int price = Integer.valueOf(tk.nextToken());
			int cost = Integer.valueOf(tk.nextToken());
			prices[i] = price;
			costs[i] = cost;
		}
		
		int max = 0;
		int maxPrice = 0;
		for(int i=0; i<prices.length; i++) {
			
			int next = prices[i];
			int sum = 0;
			
			for(int j=0; j<prices.length; j++) {
				
				int nextPrice = prices[j];
				if(next <= nextPrice) {
					int result =next-costs[j];
					if(result >= 0) {
						sum+=result;
					}
				}				
			}
			
			if(sum >= max) {
				
				if(sum == max) {
					maxPrice = Math.min(maxPrice, next);
				}else {
					max = sum;
					maxPrice = next;
				}
				
			}
			
		}
		System.out.println(maxPrice);
		
	}
}