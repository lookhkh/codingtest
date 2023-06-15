import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		for(int i=0; i<n; i++) {
			
			int m = Integer.valueOf(br.readLine());
			
			Map<String, Integer> map = new HashMap<>();
			String[] arr = new String[m];
			for(int z =0; z<m; z++) {
				
				String next = br.readLine();
				arr[z] = next;
				for(int x = 1; x<=next.length(); x++) {
					String nextChar = next.substring(0,x);
					map.put(nextChar,map.getOrDefault(nextChar, 0)+1);
				}
				
			}
			
			boolean result = true;
			for(int z =0; z<arr.length; z++) {
				String target = arr[z];
				if(map.get(target) > 1) {
					System.out.println("NO");
					result = false;
					break;
				}
			}
			
			if(result)System.out.println("YES");
			
		}
		
	}
}