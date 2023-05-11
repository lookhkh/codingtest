
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String[] orders;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		orders = new String[n];
		
		for(int i=0; i<n; i++) {
			orders[i] = br.readLine();
		}
		
		dfs(0,"", new boolean[10]);
		
		System.out.println(answer);
		
	}
	private static void dfs(int curIdx, String str, boolean[] ch) {
		
		if(curIdx == 3) {
			
			boolean result = true;
			
			for(String order : orders) {
				
				String[] or = order.split(" ");
				
				String guess = or[0];
				int cnt = Integer.valueOf(or[1]);
				int ball = Integer.valueOf(or[2]);
				
				int cntNum =0;
				int ballNum = 0;
				
				
				for(int i=0; i<str.length(); i++) {
					
					char nextStr = str.charAt(i);

					for(int j=0; j<guess.length(); j++) {
						
						char nextGuess = guess.charAt(j);
						
						if(nextStr == nextGuess) {
							if(i == j) cntNum++;
							else ballNum ++;
						}
						
					}
				}
				
				if(cntNum == cnt && ball == ballNum) continue;
				result = false;
				
				
			}
			
			if(result) {
				answer++;
			}
			
			
		}else {
			
			for(int i=1; i<=9; i++) {
				
				if(ch[i]) continue;
				ch[i] = true;
				dfs(curIdx+1,str+String.valueOf(i),ch);
				ch[i] = false;
				
			}
			
		}

	}
}
