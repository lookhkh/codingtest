import java.util.*;
class Solution {
    
    int[] nx = new int[]{-1,1,0,0};
    int[] ny = new int[]{0,0,-1,1};
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int len = board.length;
        boolean[][][] his = new boolean[len][len][4];
        
        PriorityQueue<Road> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt, t2.cnt));
        que.add(new Road(0,0,0,0));
        
        while(!que.isEmpty()){
            
            Road next = que.poll();
            if(next.x == len-1 && next.y == len-1){
                answer = Math.min(answer, next.cnt);
            }
            his[next.x][next.y][next.dir] = true;
            
            for(int i=0; i<4; i++){
                
                int nx = this.nx[i]+next.x;
                int ny = this.ny[i]+next.y;
                
                if(nx >=0 && ny >=0 && nx < len && ny < len && !his[nx][ny][i] && board[nx][ny] == 0){
                    
                    int nextCost = next.cnt + next.isCorner(i);
                    Road newRoad = new Road(nx, ny, nextCost, i);
                    que.add(newRoad);
                }
                
            }
            
            
        }
        
        
        return answer;
    }
}

class Road{
    int cnt;
    //상하좌우 : 0123
    int dir;
    int x;
    int y;
    
    public Road(int x, int y, int cnt, int dir){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.dir = dir;
    }
    
    int isCorner(int dir){
        if(this.x == 0 && this.y == 0 ) return 100;
        if((this.dir == 0 || this.dir == 1) && (dir == 2 || dir == 3)) return 600;
        if((this.dir == 2 || this.dir == 3) && (dir == 0 || dir == 1)) return 600;
        return 100;
    }
}