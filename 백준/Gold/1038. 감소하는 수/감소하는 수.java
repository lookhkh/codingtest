import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int n;
	
	static int cnt = -1;
	static List<Long> results;
	static int[] list = new int[] {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.valueOf(br.readLine());
		results = new ArrayList<>();
		
		
		for(int i=1; i<=10; i++) {
			for(int j=0; j<list.length; j++) {
				 combination(i,1, j ,list[j]);

			}
			
		}
		results.sort(null);
		if(results.size()<= n) {
		System.out.println(-1);
		}else {
			System.out.println(results.get(n));
		}
	}
	
	private static void combination(int targetLength, int curLength, int curIdx, long path) {
		
		if(targetLength == curLength) {
			cnt++;
//			System.out.println(path+"  "+cnt+"  "+targetLength);
			results.add(path);
			
		}else {
			
			for(int i= curIdx-1; i>=0; i--) {
				combination(targetLength, curLength+1, i, path*10+list[i]);
				
			}
			
			
		}

	}

	
}
