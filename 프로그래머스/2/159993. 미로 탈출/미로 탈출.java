import java.util.*;
class Solution {
    char[][] map;
    int[] start;
    int[] lever;
    int[] end;
    
    int[] ny = new int[]{-1,1,0,0};
    int[] nx = new int[]{0,0,-1,1};
    
    public int solution(String[] maps) {
        int answer = 0;
        map = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            
            String next = maps[i];
            char[] arr = next.toCharArray();
            
            for(int j=0; j<arr.length; j++){
                
                char nextChar = arr[j];
                if(nextChar == 'S') {
                    start = new int[]{i,j};
                }else if(nextChar =='L'){
                    lever = new int[]{i,j};
                }else if(nextChar == 'E'){
                    end = new int[]{i,j};
                }
                map[i][j] = nextChar;
            }
        }
        
        int numToLever = bfs(start, lever);
        if(numToLever == 0) return -1;
        System.out.println(numToLever);
        int numToEnd = bfs(lever, end);
        if(numToEnd == 0) return -1;
        System.out.println(numToEnd);

    
        return numToLever + numToEnd;
    }
    
    int bfs(int[] start, int[] target){
        PriorityQueue<Edge> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt, t2.cnt));
        boolean[][] his = new boolean[map.length][map[0].length];
        
        que.add(new Edge(start[0], start[1], 0));
        while(!que.isEmpty()){
            
            Edge edge = que.poll();
            if(his[edge.y][edge.x]) continue;
            his[edge.y][edge.x] = true;
            if(edge.y == target[0] && edge.x == target[1]){
                return edge.cnt;
            }
           
            for(int i=0; i<4; i++){
                
                int ny = edge.y+this.ny[i];
                int nx = edge.x+this.nx[i];
                
                if(ny >=0 && ny < map.length && nx >=0 && nx < map[0].length){
                    if(his[ny][nx]) continue;
                    if(map[ny][nx] == 'X') continue;
                    que.add(new Edge(ny, nx, edge.cnt+1));
                }
                
            }
            
            
        }
        
        return 0;
    }
}

class Edge{
    int x;
    int y;
    int cnt;
    
    Edge(int y, int x, int cnt){
        this.y = y;
        this.x = x;
        this.cnt = cnt;
    }
}