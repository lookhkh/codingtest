//https://school.programmers.co.kr/learn/courses/30/lessons/154538#

import java.util.Queue;
import java.util.LinkedList;


class Solution {
    
    int MAXIMUM = Integer.MAX_VALUE;
    int max = MAXIMUM;
    int xv;
    int yv;
    int nv;
    public int solution(int x, int y, int n) {

        xv = x;
        yv = y;
        nv = n;
        
        if(x == y) {
            return 0;
        }
        
        int result = bfs(x);
        
        
        return result;
    }
    
    public int bfs(int start){
        int max = 1_000_001;
        
        Queue<Integer> que = new LinkedList<>();
        
        boolean[] ch = new boolean[max];
        
        que.add(start);
        
        int result = 0;
        while(!que.isEmpty()){
            
            int size = que.size();
            
            for(int z = 0; z<size; z++){
                
                int next = que.poll();
                
                if(ch[next]) continue;
                ch[next] = true;
                
                if(next == yv){
                    
                    return result;
                }
                
                for(int i=0; i<3; i++){
                    
                    if(i == 0 && next+nv <= yv) que.add(next+nv);
                    else if(i == 1 && next* 2 <= yv) que.add(next * 2);
                    else if(i == 2 && next* 3 <= yv) que.add(next * 3);
                    
                    
                }
                
                
            }
            
            result++;
            
        }
        
        return -1;
    }
}