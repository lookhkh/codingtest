import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (t1,t2)->{
            if(t1[1]!=t2[1]) return Integer.compare(t1[1],t2[1]);
            return Integer.compare(t1[0],t2[0]);
        });
        
        int answer = 0;
        int lastPoint = -30_001;
        for(int[] route : routes){
            if(route[0] <= lastPoint && route[1] >= lastPoint) continue;
            lastPoint = route[1];
            answer++;
            
            
        }
        
        return answer;
    }
}