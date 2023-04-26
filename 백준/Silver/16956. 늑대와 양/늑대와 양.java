import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

	static int n;
	static int m;
	static char[][] map;
	
	static List<int[]> empty;
	static List<int[]> wolf; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t= new StringTokenizer( br.readLine() ," ");
		
		n = Integer.valueOf(t.nextToken());
		m = Integer.valueOf(t.nextToken());
		
		map = new char[n][m];
		empty = new ArrayList<>();
		wolf = new ArrayList<>();
		for(int i=0; i<n; i++) {
			
			String str = br.readLine();


			for(int j=0; j<m; j++) {
				char nextChar =  str.charAt(j);
				
				if(nextChar =='.') {
					empty.add(new int[] {i,j});
					map[i][j] = 'D';
				}else{
				
					if(nextChar =='W') wolf.add(new int[] {i,j});
					
					map[i][j] = nextChar;
				}
			}
		}
		
		int[] dirX = new int[] {-1,1,0,0};
		int[] diry = new int[] {0,0,-1,1};
		
		boolean result = true;

		for(int i=0; i<wolf.size() && result; i++) {
			
			int[] start =  wolf.get(i);
			
			for(int j=0; j<4; j++) {
				
				int nextX = start[0]+dirX[j];
				int nextY = start[1]+diry[j];
				
				if(nextX>=0 && nextX<n && nextY >=0 && nextY < m) {
					
					if(map[nextX][nextY] == 'S') {
						result = false;
						break;
					}
					
				}
				
			}
			
		}
		
		if(!result) {
			
			System.out.println(0);
			
		}else {
			
			System.out.println(1);
			
			for(char[] w : map) {
				StringBuilder b= new StringBuilder();
				for(char ww : w) {
					b.append(ww);
				}
				System.out.println(b.toString());
			}
			
		}
		
	}
}
