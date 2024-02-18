import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] array;
    static int n;
    static int m;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        StringTokenizer tk;
        
        tk = new StringTokenizer(br.readLine()," ");
       
         n = Integer.parseInt(tk.nextToken());
         m = Integer.parseInt(tk.nextToken());
        
        array = new int[n][m];
        
        for(int i=0; i<n; i++) {
            String row = br.readLine();
            
            for(int j=0; j<row.length(); j++) {
                array[i][j] = Integer.valueOf(row.charAt(j)-'0');
            }
            
        }
        
        bfs(0,0);
        br.close();
       
    }

    private static void bfs(int x, int y) {
    	
    	Queue<int[]> que = new LinkedList<>();
    	que.add(new int[] {x,y});
    	
    	array[x][y] = 0;
    	
    	int steps = 0;
    	
    	while(!que.isEmpty()) {
    		
    		int size = que.size();
    		steps++;
    		
    		for(int j=0; j<size; j++) {
	 
    			int[] currentPosition = que.poll();
	    		

	    		if(currentPosition[0] == n-1 && currentPosition[1]== m-1) {
	    			System.out.println(steps);

	    			while(!que.isEmpty()) que.poll();
	    			
	    			return;
	    		}
	    		
	    		for(int i=0; i<4; i++) {
	    			
	    			int moveX = currentPosition[0]+dx[i];
	    			int moveY = currentPosition[1]+dy[i];
	    			
	    			if(moveX >=0 && moveX < n && moveY >=0 && moveY <m) {
	    				if(array[moveX][moveY] == 1) {
	    					array[moveX][moveY] = 0;
	    					que.add(new int[]{moveX,moveY});
	    				}
	    			}	
	    		}
	    	}    	
    }
    	
    	
    	
 }
    
  
}

