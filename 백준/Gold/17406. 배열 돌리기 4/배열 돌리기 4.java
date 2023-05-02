
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static long answer = Integer.MAX_VALUE;
	
	static int n;
	static int m;
	static int k;
	
	static List<int[]> commands;
	static int[][] original;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tk = new StringTokenizer(br.readLine()," ");
		
		n = Integer.valueOf(tk.nextToken());
		m = Integer.valueOf(tk.nextToken());
		k = Integer.valueOf(tk.nextToken());
		
		original = new int[n][m];
		
		for(int i=0; i<n; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			
			for(int j=0; j<m; j++) {
				
				int w = Integer.valueOf(tk.nextToken());
				
				original[i][j] = w;
				
			}
		}
		
		
		commands = new ArrayList<>();

		for(int i=0; i<k; i++) {
			
			tk = new StringTokenizer(br.readLine()," ");
			int nn = Integer.valueOf(tk.nextToken())-1;
			int mm = Integer.valueOf(tk.nextToken())-1;
			int kk = Integer.valueOf(tk.nextToken());
			commands.add(new int[] {nn,mm,kk});
			
		}
		
		

		permutation(0,new boolean[commands.size()], new int[commands.size()][3]);
		
		System.out.println(answer);

	}

	private static void permutation(int idx, boolean[] bs, int[][] path) {
		
		if(idx == commands.size()) {

			int[][] startArr = original;
			
			for(int i=0; i<path.length; i++) {
				
			
				int[] command = path[i];
				
				int startX = command[0] - command[2];
				int startY = command[1] - command[2];
				
				int endX = command[0] + command[2];
				int endY = command[1] + command[2];
				
				
				
				
				while(startX != endX && startY!=endY) {
					
					int[][] temp = rotate(startArr,startX,startY,endX,endY);
					startArr = temp;
					startX+=1;
					startY+=1;
					endX-=1;
					endY-=1;
					
				}
			}

			long min = Integer.MAX_VALUE;
			for(int i=0; i<startArr.length; i++) {
				
				
				long temp = 0;
				for(int j=0; j<startArr[i].length; j++) {
					temp+= startArr[i][j];
				}
				
				min = Math.min(temp, min);
			}
			
			answer = Math.min(answer, min);

		}else {
			
			for(int i=0; i<commands.size(); i++) {
				
				if(bs[i]) continue;
				
				bs[i] = true;
				path[idx] = commands.get(i);
				permutation(idx+1, bs,path);
				bs[i] = false;
			}
			
			
			
		}
		
	}

	private static int[][] rotate(int[][] original,int startX, int startY, int endX, int endY) {

		int[][] temp = new int[original.length][original[0].length];
		
		for(int i=0; i<original.length; i++) {
			for(int j=0; j<original[i].length; j++) {
				temp[i][j] = original[i][j];
			}
		}
		
		//위 
		
		temp[startX][startY] = original[startX+1][startY];
		for(int i=startY+1; i<=endY; i++) {
			temp[startX][i] = original[startX][i-1]; 
		}
		
		//오른쪽 아래
		
		temp[startX][endY] = original[startX][endY-1];
		for(int i=startX+1; i<=endX; i++) {
			temp[i][endY] = original[i-1][endY];
		}
		
		//아래
		
		temp[endX][endY] = original[endX-1][endY];
		for(int i=endY-1; i>=startY; i--) {
			temp[endX][i] = original[endX][i+1];
		}
		
		for(int i=endX-1; i>=startX; i--) {
			temp[i][startY] = original[i+1][startY];
		}

		return temp;
	}

}
