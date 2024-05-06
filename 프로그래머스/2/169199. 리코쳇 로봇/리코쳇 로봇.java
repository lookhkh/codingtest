import java.util.*;
class Solution {
    int[] nx = new int[]{-1,1,0,0};
    int[] ny = new int[]{0,0,-1,1};
    char[][] map;
    int[] start;
    int[] goal;
    public int solution(String[] board) {
        this.map = new char[board.length][board[0].length()];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                String next = board[i];
                if(next.indexOf("R") >= 0){
                    this.start = new int[]{i, next.indexOf("R")};
                }else if(next.indexOf("G") >= 0){
                    this.goal = new int[]{i, next.indexOf("G")};
                }
                map[i] = board[i].toCharArray();
            }
        }
        
        PriorityQueue<Pos> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt,t2.cnt));
        
        que.add(new Pos(this.start[0], this.start[1], 0));
        boolean[][] his = new boolean[this.map.length][this.map[0].length];
        
        while(!que.isEmpty()){
            
            Pos next = que.poll();
            if(his[next.x][next.y]) continue;
            his[next.x][next.y] = true;
            if(goal[0] == next.x &&goal[1] == next.y) return next.cnt;
            
            for(int i=0; i<4; i++){
                
                int nx = next.x;
                int ny = next.y;
                //nx >= 0 && nx < this.map.length && ny >= 0 && ny < this.map[0].length
                while(true){
                  
                    nx+=this.nx[i];
                    ny+=this.ny[i];
                    
                    if(!(nx >= 0 && nx < this.map.length && ny >= 0 && ny < this.map[0].length) || this.map[nx][ny] =='D'){
                        nx-=this.nx[i];
                        ny-=this.ny[i];
                        break;
                    }
                }
                
                if(his[nx][ny]) continue;
                que.add(new Pos(nx, ny, next.cnt+1));
                
            }
            
        }
        
        return -1;
    }
}

class Pos{
    int x;
    int y;
    int cnt;
    
    Pos(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}