import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        return bfs(x,y,n);
        
    }
    
    public int bfs(int x, int y, int n){
        Queue<Integer> que = new LinkedList<>();
        boolean[] ch = new boolean[y+1];
        ch[x] = true;
        que.add(x);
        
        int answer = 0;
        
        while(!que.isEmpty()){
            
            int size = que.size();
            
            for(int s = 0; s<size; s++){
            
                int next = que.poll();

                if(next == y) return answer;

                for(int i=0; i<3; i++){

                    int nextX = next;

                    if(i == 0) nextX = next+n;   
                    if(i == 1) nextX = next *2;
                    if(i == 2) nextX = next *3;

                    if(nextX > y) continue;
                    if(ch[nextX]) continue;
                    
                    ch[nextX] = true;
                    
                    que.add(nextX);

                }
                
                
            }
            answer++;
        }
        
        return -1;
        
    }
}