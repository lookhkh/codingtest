/*
    동서남북으로 캐릭터를 이동할 수 있다.
    BFS
*/
import java.util.*;
class Solution {
    static class Point{
        int x;
        int y;
        int cnt;
        
        public Point(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    //상하좌우
    int[] dirX = new int[]{-1,1,0,0};
    int[] dirY = new int[]{0,0,-1,1};
    int[][] map;
    public int solution(int[][] maps) {
        int answer = 0;
        map = maps;
        
        
        return bfs();
    }
    
    public int bfs(){
        
        Queue<Point> que = new LinkedList<>();
        boolean[][] ch = new boolean[map.length][map[0].length];
        que.add(new Point(0,0,1));
        
        ch[0][0] = true;

        while(!que.isEmpty()){
            
            Point next = que.poll();
            
            if(next.x == map.length-1 && next.y == map[0].length-1){

                return next.cnt;
            }
            
            for(int i=0; i<4; i++){
                
                int nextX = next.x+dirX[i];
                int nextY = next.y+dirY[i];
                
                if(nextX >=0 && nextY >=0 && nextX < map.length && nextY < map[0].length){
                    
                    if(map[nextX][nextY] == 0) continue;
                    if(ch[nextX][nextY]) continue;
                    
                    ch[nextX][nextY] = true;
                    
                    que.add(new Point(nextX,nextY,next.cnt+1));
                    
                }
                
            }
            
            
        }
        
        
        return -1;
        
    }
}