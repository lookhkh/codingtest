import java.util.*;
class Solution {
    int[][] memo;
    boolean[][] puddlePath;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        memo = new int[n][m];
        puddlePath = new boolean[n][m];
        
        for(int[] puddle : puddles){
            puddlePath[puddle[1]-1][puddle[0]-1] = true;
        }
        
        for(int[] mm : memo){
            Arrays.fill(mm,-1);
        }
 
        return dfs(0,0,n-1,m-1, puddles) % 1_000_000_007;
    }
    
    int dfs(int y, int x, int ny, int nx, int[][] puddles){
        if(y > ny || x > nx) return 0;
        if(y == ny && x == nx){
            return 1;
        }else if(checkPuddle(puddles, y, x)){
            return memo[y][x] = 0;
        }else{
            if(memo[y][x] != -1) return memo[y][x] % 1_000_000_007;
            memo[y][x] = 0;
            return memo[y][x] += dfs(y+1,x,ny,nx, puddles) % 1_000_000_007+dfs(y,x+1, ny,nx,puddles)% 1_000_000_007;
        }
        
    }
    boolean checkPuddle(int[][] puddles, int y, int x){
        if(puddlePath[y][x]) return true;
        return false;
    }
}