import java.util.*;

class Solution {
    int[][] map;
    int total;
    public List<Integer> solution(int n) {
        int[] answer = new int[n];
        total = n;
        map = new int[n][n];
        
        dfs(1,0,0,n,0);
    
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<map.length; i++){
            
            int[] temp = map[i];
            
            for(int j=0; j<temp.length; j++){
                if(temp[j]!=0)list.add(temp[j]);
            }
            
        }
        
        
        return list;
    }
    
    public void dfs(int num, int x,int y, int n, int padding){
        if(x >= total) return;
        if(map[x][y]!=0) return;
        
        for(int i=x; i<x+n; i++){
            
            map[i][y] = num++;
            if(i == x+n-1){
                for(int j = y+1; j<y+n; j++){
                    map[i][j] = num++;
                }
            }
        }
        
        for(int i = x+n-2; i>x; i--){
            
            map[i][i-padding] = num++;
            
        }
                
        dfs(num,x+2,(x+2)/2,n-3, padding+1);
        
    }
    
    public void print(int[][] map){
        
        for(int i=0; i<map.length; i++){
            
            String t= "";
            
            for(int j=0; j<map[i].length; j++){
                t += map[i][j]+" ";
            }
                        
        }
        
    }
}