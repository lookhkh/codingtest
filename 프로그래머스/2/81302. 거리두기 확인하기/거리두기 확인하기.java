/**
0. 대기실은 5 * 5
1. 맨해든 거리 2 이하로 앉지 말라.
2. 단 응시자가 앉아있는 자리 사이가 파티션으로 막혀 있을 경우, 1은 무시한다.

**/
import java.util.*;
class Solution {
    
    int[] dy = new int[]{-1,1,0,0};
    int[] dx = new int[]{0,0,-1,1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        for(int i=0; i<places.length; i++){
            String[] place = places[i];
            for(int j=0; j<place.length; j++){
                String next = place[j];
                for(int z =0; z<next.length(); z++){
                    char nextP = next.charAt(z);
                    if(nextP == 'P'){
                        if(answer[i] ==0) break;
                        answer[i] = check(place, j, z);
                    }
                }
            }
        }
        return answer;
    }
    
    int check(String[] place, int y, int x){
        
        PriorityQueue<int[]> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1[0],t2[0]));
        boolean[][] path = new boolean[place.length][place[0].length()];
        que.add(new int[]{0,y,x});
        
        while(!que.isEmpty()){
            
            int[] next = que.poll();
            if(path[next[1]][next[2]]) continue;

            if(next[0] != 0 && next[0] <= 2 && place[next[1]].charAt(next[2]) =='P') return 0;
            
            path[next[1]][next[2]] = true;
            
            for(int i=0; i<4; i++){
                
                int ny = next[1]+dy[i];
                int nx = next[2]+dx[i];
                
                if(nx >=0 && nx< 5 && ny >=0 && ny < 5){
                    if(path[ny][nx]) continue;
                    if(place[ny].charAt(nx) =='X') continue;
                    que.add(new int[]{next[0]+1, ny, nx});
                }
                
                
            }
            
        }
        
        
        return 1;
        
    }
   
}

