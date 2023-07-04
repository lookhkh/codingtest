
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		List<String> strings = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			strings.add(br.readLine());
		}
		
		strings.sort((t1,t2)->Integer.compare(t2.length(), t1.length()));

		/*
		 * dp[x] = > x까지의 문자열 중 접두어x의 최대 크기.
		 * 
		 * */
		
		List<List<String>> dp = new ArrayList<>();
		
		for(int i=0; i<strings.size(); i++) {
			
			String next = strings.get(i);
			List<String> arr = new ArrayList<>();
			arr.add(next);
			dp.add(arr);
			
			for(int j=0; j<strings.size(); j++) {
				String temp = strings.get(j);
				if(next.startsWith(temp) || next.equals(temp)) continue;
				boolean isOk = true;
				for(int z=0; z<arr.size(); z++) {
					
					String zItem = arr.get(z);
					if(zItem.startsWith(temp) || temp.startsWith(zItem) || temp.equals(zItem)) {
						isOk= false;
						break;
					}
					
				}
				
				if(isOk)arr.add(temp);
				
			}
			
		}
		
		int max = dp.stream()
					.mapToInt(t->t.size())
					.max()
					.getAsInt();
		
		System.out.println(max);
	}
}
