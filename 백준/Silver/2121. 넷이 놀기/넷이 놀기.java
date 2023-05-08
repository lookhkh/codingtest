import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	static Map<Integer, List<Integer>> map;
	static int targetX;
	static int targetY;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		arr = new int[n][2];
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		map = new HashMap<>();
		
		targetX = Integer.valueOf(tk.nextToken());
		
		targetY = Integer.valueOf(tk.nextToken());
		
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			int x = Integer.valueOf(tk.nextToken());
			
			int y = Integer.valueOf(tk.nextToken());
			
			arr[i][0] = x;
			
			arr[i][1] = y;
			
		}
	
		Arrays.sort(arr,(t1,t2)->{
			if(t1[0] == t2[0]) return Integer.compare(t1[1], t2[1]);
			else {
				
				return Integer.compare(t1[0], t2[0]);
				
			}
		});
		
		for(int[] w : arr) {
			
			int x = w[0];
			int y = w[1];
			
			if(map.containsKey(x)) {
				map.get(x).add(y);
			}else {
				List<Integer> list = new ArrayList<>();
				list.add(y);
				map.put(x, list);
			}
			
		}
		
		int answer = 0;
		
		for(int i=0; i<arr.length; i++) {
			
			int[] next = arr[i];
			int x = next[0];
			int y = next[1];
			
			int[] leftBottom = new int[] {x,y+targetY};
			int[] rightTop = new int[] {x+targetX,y};
			int[] rightBottm = new int[] {x+targetX,y+targetY};
			
			boolean result = find(leftBottom) && find(rightTop) && find(rightBottm);
			
			if(result) answer++;
		}
		
		System.out.println(answer);
	}

	private static boolean find(int[] leftBottom) {

		List<Integer> list = map.getOrDefault(leftBottom[0], new ArrayList<>());
		
		if(list.isEmpty()) return false;
		
		int target = leftBottom[1];
		
		return list.contains(target);
		
	}
}
