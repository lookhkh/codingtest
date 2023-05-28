/*
    맨해튼 거리가 2 이하로 앉지 마시오.
*/
import java.util.*;
class Solution {
    
    static class Step{
        int x;
        int y;
        int cnt;
        public Step(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    int[] dirX = new int[]{-1,1,0,0};
    int[] dirY = new int[]{0,0,-1,1};
    char[][] map;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
                
        for(int idx = 0; idx<places.length; idx++){
            
            String[] place = places[idx];
            
            List<int[]> people = new ArrayList<>();
            
            map = createMap(place,people);
            
            if(people.size() == 0) answer[idx] = 1;
            

            boolean result = true;
            
            for(int[] n: people){
                
                result = bfs(n);
                if(!result) {
                    answer[idx] = 0;
                    break;
                }
            }
            

           if(result) answer[idx] = 1;
            
        }
        
        return answer;
    }
    
    public boolean bfs(int[] start){
       
        Queue<Step> que = new LinkedList<>();
        
        que.add(new Step(start[0],start[1],0));
        
        boolean[][] ch = new boolean[5][5];
        
        ch[start[0]][start[1]] = true;
        
        while(!que.isEmpty()){
            
            Step next = que.poll();
            //System.out.println(next.x+"  "+next.y+"  "+next.cnt+"  "+map[next.x][next.y]);
            
            if(map[next.x][next.y] == 'P' && !( next.x ==start[0] && next.y ==start[1]) ){

                if(next.cnt <= 2) {
                    System.out.println("찾았다");
                    return false;
                }
                continue;
            }
            
            for(int i=0; i<4; i++){
                int nextX = next.x+dirX[i];
                int nextY = next.y+dirY[i];
                
                if(nextX>=0 && nextY >=0 && nextX<5 && nextY<5) {
                    if(ch[nextX][nextY]) continue;
                    if(map[nextX][nextY] == 'X') continue;
                    ch[nextX][nextY] = true;
                    que.add(new Step(nextX,nextY, next.cnt+1));
                }
            }
        }
        
        
        return true;
    }
    
    public char[][] createMap(String[] arr, List<int[]> people){
        char[][] map = new char[5][5];
        
        for(int i=0; i<arr.length; i++){
            String n = arr[i];
            for(int j=0; j<n.length(); j++){
                
                char next = n.charAt(j);
                if(next == 'P') people.add(new int[]{i,j});
                map[i][j] = next;
                
            }
        }
        
        return map;
        
    }
    
    public boolean isValid(int[] a, int[] b){
        return result(a,b)>2;
    }
    
    public int result(int[] a, int[] b){
        return Math.abs(a[0] - b[0])+Math.abs(a[1] - b[1]) ;
    }
}