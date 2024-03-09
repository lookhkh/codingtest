import java.util.*;
class Solution {
    int[] row = new int[]{-1,1,0,0};
    int[] col = new int[]{0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] path = new boolean[maps.length][maps[0].length];
        
        PriorityQueue<Way> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt,t2.cnt));
        que.add(new Way(0,0,1));
        
        while(!que.isEmpty()){
            
            Way next = que.poll();
            if(path[next.x][next.y]) continue;
            path[next.x][next.y] = true;
            if(next.x == maps.length-1 && next.y == maps[0].length-1){
                return next.cnt;
            }
            
            for(int i=0; i<4; i++){
                int nextX = next.x+row[i];
                int nextY = next.y+col[i];
                if(nextX >=0 && nextY >= 0 && nextX < maps.length && nextY<maps[0].length){
                    if(path[nextX][nextY]) continue;
                    if(maps[nextX][nextY] == 0) continue;
                    que.add(new Way(nextX,nextY, next.cnt+1));
                }
            }
            
            
        }
        
        
        return -1;
    }
    
    class Way{
        int cnt;
        int x;
        int y;
        
        Way(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}