import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] nums = new int[25*25+1];
	
    static int[][] array;
    static int n;


    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        
        StringTokenizer tk;
        
        tk = new StringTokenizer(br.readLine(),"");
       
         n = Integer.parseInt(tk.nextToken());

 
        array = new int[n][n];
        
        for(int i=0; i<n; i++) {
            String row = br.readLine();
            
            for(int j=0; j<row.length(); j++) {
                array[i][j] = Integer.valueOf(row.charAt(j)-'0');
            }
            
        }
        
        
        int level = 1;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		dfs(level, i,j);
        		level++;
        	}
        }
        
        Arrays.sort(nums);
        int cnt = 0;
        for(int num : nums) {
        	if(num>0) cnt++;
        }
        
        System.out.println(cnt);
        for(int num : nums) {
        	if(num>0) System.out.println(num);
        }
        
    	
    	
 }


	private static void dfs(int level, int x, int y) {
		if(array[x][y] == 0 ) {
			return;
		}
		
		array[x][y] = 0;
		nums[level] += 1;
		
		for(int i=0; i<4; i++) {
			int mx = dx[i]+x;
			int my = dy[i]+y;
			
			if(mx>=0 && my>=0 && mx < n && my < n) {
				dfs(level,mx,my);
			}
		}
	}
    
  
}

