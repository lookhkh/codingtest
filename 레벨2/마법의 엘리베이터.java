//https://school.programmers.co.kr/learn/courses/30/lessons/148653#
import java.util.PriorityQueue;


class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        
        return bfs(storey);
        
    }
    
    public int bfs(int start){
        
        PriorityQueue<int[]> que = new PriorityQueue<>((t1,t2)->t1[1]-t2[1]);
        que.add(new int[]{start,0});
        
        int result = 0;
        while(!que.isEmpty()){
            
            int[] next = que.poll();
            
            if(next[0] < 0) continue;
            
            if(next[0] == 0){
                return next[1] ;
            }
            
            int nextOne = next[0];
            
            int expo = 1;
            
            while(nextOne % (int)Math.pow(10,expo) == 0) expo++;
            
            int rest = nextOne % (int)Math.pow(10,expo);
            int cnt = rest / (int)Math.pow(10,expo-1);

            que.add(new int[]{nextOne+((int)Math.pow(10,expo)-rest), next[1]+(10-cnt)});
            que.add(new int[]{nextOne-(rest), next[1]+cnt});

        }
        
        return 1;
        
    }
}