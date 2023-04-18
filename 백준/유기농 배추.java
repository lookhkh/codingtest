//https://www.acmicpc.net/problem/1012
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

		static int[] rowD = new int[] {-1,1,0,0};
	    static int[] colD = new int[] {0,0,1,-1};
	    
	     public static void main(String[] args) throws NumberFormatException, IOException {
	         
	         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	         
	         int wholeTestCases = Integer.valueOf(br.readLine());
	         
	         for(int i=0; i<wholeTestCases; i++) {
	             
	             StringTokenizer tk;
	             
	             tk = new StringTokenizer(br.readLine()," ");
	             
	             int cols = Integer.valueOf(tk.nextToken());
	             int rows = Integer.valueOf(tk.nextToken());
	             int nums = Integer.valueOf(tk.nextToken());
	             
	             int[][] arr = new int[rows][cols];
	              
	             for(int j=0; j<nums; j++) {
	                 tk = new StringTokenizer(br.readLine()," ");
	                 
	                 int col = Integer.valueOf(tk.nextToken());
	                 int row = Integer.valueOf(tk.nextToken());
	                     
	                 arr[row][col] = 1;                 
	             }
	             
	             boolean[][] ch = new boolean[rows][cols];
		         int result = 0;

	             for(int x=0; x<arr.length; x++) {
	            	 for(int y=0; y<arr[i].length; y++) {
	            		 
	            		 if(arr[x][y] != 1) continue;
	            		 if(ch[x][y]) continue;
	            		 result+= bfs(arr,new int[] {x,y}, ch);
	            		 
	            	 }
	            	 
	             }	             
            	 System.out.println(result);

	         }
	}

		private static int bfs(int[][] arr, int[] start, boolean[][] ch) {

			Queue<int[]> que = new LinkedList<>();
			que.add(start);
			
			while(!que.isEmpty()) {
				
				int[] next = que.poll();
				if(ch[next[0]][next[1]]) continue;
				ch[next[0]][next[1]] = true;
				
				for(int i=0; i<4; i++) {
					
					int nextX  =next[0]+rowD[i];
					int nextY  =next[1]+colD[i];
					
					if(nextX>=0 && nextY>=0 && nextX<ch.length && nextY<ch[0].length) {
						
						if(ch[nextX][nextY]) continue;
						if(arr[nextX][nextY] == 0) continue;
						que.add(new int[] {nextX,nextY});
						
					}
					
				}
				
			}
			
			return 1;
		}
}
