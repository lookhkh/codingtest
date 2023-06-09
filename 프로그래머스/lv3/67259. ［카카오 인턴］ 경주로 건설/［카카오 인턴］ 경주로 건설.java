import java.util.*;

class Solution {
    static class Point{
        
        int x;
        int y;
        int cnt;
        int dir;
        
        public Point(int x, int y, int cnt, int dir){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dir = dir;
        }
        
    }
    int[] dirX = new int[]{-1,1,0,0};
    int[] dirY = new int[]{0,0,-1,1};
    int[][] map;
    int MAX = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        int answer = 0;
        map = board;
        
        return bfs(map.length-1, map[0].length-1);
            
    }
    
    //0 상 1 하 2 좌 3 우
    public int bfs(int x, int y){
        
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0,0,0,1));
        que.add(new Point(0,0,0,3));
        
        int[][][] ch = new int[map.length][map[0].length][4];
        
        for(int[][] w : ch){
            for(int[] p : w){
                    Arrays.fill(p,MAX);
            }
        }

        ch[0][0][1] = ch[0][0][3]  = 0;
        
        int min = Integer.MAX_VALUE;
        
        while(!que.isEmpty()){
            
            Point next = que.poll();
            
            if(next.x == x && next.y == y){
                min = Math.min(min, next.cnt);
                continue;
            }
            
            for(int i=0; i<4; i++){
                
                int nextX = next.x+dirX[i];
                int nextY = next.y+dirY[i];
                
                if(nextX >=0 && nextY >=0 && nextX < map.length && nextY < map[0].length){
                    
                    if(map[nextX][nextY] == 1) continue;

                    int nextNum  = next.cnt + 100;
                    
                    if( (next.dir == 0 && i == 1) || 
                        (next.dir == 1 && i == 0) || 
                        (next.dir == 2 && i == 3) || 
                        (next.dir ==3 && i == 2) ) continue;
                    
                    if( !(next.x==0 && next.y ==0) && i != next.dir) nextNum+=500;

                    if(ch[nextX][nextY][i] < nextNum) continue;

                    ch[nextX][nextY][i] = nextNum;
                    
                    que.add(new Point(nextX, nextY, nextNum,i));
                    
                }
                
            }
            
        }
        
        return min;

    }
}