import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String line;
	static boolean[] ch;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(br.readLine());
	
		line = br.readLine();
		
		ch = new boolean[num];
		int answer = 0;

		for(int i=0; i<num; i++) {
			
			if(ch[i]) continue;
			answer += dfs(i,i);
			
		}
		
		System.out.println(answer);
		
		
	}
	private static int dfs(int current, int previous) {

		ch[current] = true;
		
		char nextChar = line.charAt(current);
		int nextIdx = -1;
				
		if(nextChar == 'E') {
			
			nextIdx = current+1;
			
		}else if(nextChar == 'W') {
			
			nextIdx = current-1;
		}
		
		
		if(nextIdx == previous) {
			return 1;
		}
		
		
		if(ch[nextIdx]) return 0;

		return dfs(nextIdx, current);
			
		
		
	}

}
