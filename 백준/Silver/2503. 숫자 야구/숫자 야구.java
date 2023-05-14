
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	static String[] cmds;
	static int ans = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		cmds = new String[n];
		for(int i=0; i<n; i++) {
			String n = br.readLine();
			cmds[i] = n;
		}
		
		dfs(0,new boolean[10], new String[3]);
		System.out.println(ans);
	}
	private static void dfs(int curIdx, boolean[] ch, String[] path) {
		
		if(curIdx == 3) {
			
			String next = path[0]+path[1]+path[2];
			
			for(int i=0; i<cmds.length; i++) {
				
				String[] guess = cmds[i].split(" ");
				String num = guess[0];
				int strike = Integer.valueOf(guess[1]);
				int ball = Integer.valueOf(guess[2]);
				
				
				int str = 0;
				int bal = 0;
				for(int j=0; j<3; j++) {
					char f = next.charAt(j);
					for(int z =0; z<3; z++) {
						
						char m = num.charAt(z);
						
						if(f == m) {
							if(j == z) str++;
							else bal ++;
						}
					}
					
				}
				
				if(str != strike || ball != bal) return;
				
				
			}
			ans++;
			
		}else {
			
			for(int i=1; i<=9; i++) {
				
				if(ch[i]) continue;
				ch[i] = true;
				path[curIdx] = i+"";
				dfs(curIdx+1,ch,path);
				path[curIdx] = null;
				ch[i] = false;
				
			}
			
		}

	}
}