
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int n;
	static int m;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.valueOf(st.nextToken());
		m = Integer.valueOf(st.nextToken());
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String w = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = w.charAt(j)-'0';
			}
		}
		
		dfs(0,0,new boolean[n][m]);
		
		System.out.println(max);
	}
	
	public static void dfs(int x, int y, boolean[][] ch ){
		
		if(x!=n && y == m) {
			dfs(x+1,0,ch);
		}else if(x== n ) {
			
			int total = 0;
			
			for(int i=0; i<ch.length; i++) {
				int temp = 0;
				for(int j=0; j<ch[i].length; j++) {
					if(ch[i][j]) {
						temp = temp*10+arr[i][j];
					}else {
						total += temp;
						temp = 0;
					}
				}
				total+=temp;
			}
			
			for(int j=0; j<ch[0].length; j++) {
				int temp = 0 ;

				for(int i=0; i<ch.length; i++) {
					if(!ch[i][j]) {
						temp = temp*10 + arr[i][j];
					}else {
						total+=temp;
						temp=0;
					}
				}
				total+=temp;
			}
			max = Math.max(max, total);
		}else {
			
			ch[x][y] = true;
			dfs(x,y+1,ch);
			ch[x][y] = false;
			dfs(x,y+1,ch);
			
			
		}
		
	}

}
