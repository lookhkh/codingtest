import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer tk = new StringTokenizer(br.readLine()," ");
			
			int idx = Integer.valueOf(tk.nextToken());
			
			int start = Integer.valueOf(tk.nextToken());
			
			int end = Integer.valueOf(tk.nextToken());
			
			arr[i][0] = start;
			arr[i][1] = end;
			
		}
		
		Arrays.sort(arr,(t1,t2)->Integer.compare(t1[0],t2[0]));
	
		PriorityQueue<int[]> que = new PriorityQueue<>(getComparator());
		int cnt = 0;
		for(int i=0; i<arr.length; i++) {
			int[] next = arr[i];
			
			if(que.isEmpty()) {
				que.add(arr[i]);
				cnt++;
			}else {
				
				if(que.peek()[1] > next[0]) {
					que.add(arr[i]);
					cnt++;
				}else {
					que.poll();
					que.add(next);
				}
				
			}
			
		}
		System.out.println(cnt);
	}
	private static Comparator<? super int[]> getComparator() {
		return (t1,t2)->{
			if(t1[1] == t2[1]) return Integer.compare(t1[0], t2[0]);
			return Integer.compare(t1[1], t2[1]);
		};
	}
}