import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Content{
		int price;
		int[] arr = new int[26];
		public Content(int price, String content) {
			this.price = price;
			for(int i=0; i<content.length(); i++) {
				arr[content.charAt(i)-'A'] +=1;
			}
		}
		
	}
	
	static int min = Integer.MAX_VALUE;
	static int[] targetArr  = new int[26];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target = br.readLine();
		
		for(int i=0; i<target.length(); i++) {
			targetArr[target.charAt(i)-'A']+=1;
		}
		
		int n = Integer.valueOf(br.readLine());
		Content[] arr = new Content[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			int price = Integer.valueOf(tk.nextToken());
			String name = tk.nextToken();
			arr[i] = new Content(price, name);
		}
		
		for(int i=1; i<=n; i++) {
			
			combination(i, 0, arr, 0, new int[26]);
			
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}

	private static void combination(int remain, int idx, Content[] arr, int curPrice, int[] result) {
		
		if(remain == 0) {
			boolean isOk = true;
			for(int i=0; i<targetArr.length; i++) {
				if(targetArr[i] > result[i]) {
					isOk = false;
					break;
				}
			}
			
			if(isOk) {
				min = Math.min(min, curPrice);
			}
			
		}else {
			
			for(int i=idx; i<arr.length; i++) {
				
				Content next = arr[i];
				check(next, result, true);
				
				combination(remain-1, i+1, arr, curPrice+arr[i].price,result);
				
				check(next, result, false);

			}
			
		}

	}

	private static void check(Content next, int[] result, boolean b) {
		
		for(int i=0; i<result.length; i++) {
			
			if(b) result[i]+=next.arr[i];
			else result[i]-=next.arr[i];
		}
		
	}


}
