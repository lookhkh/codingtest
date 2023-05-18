import java.util.*;


/*
    1. 한 번에 K칸을 앞으로 이동
    2. (현재까지 온 거리 ) * 2 만큼 앞으로 이동.
    
    2번 사용시 건전지 소모 X, 그러나 1번 사용시 k만큼 소모.
    건전지 사용량을 최소로 하면서 목적지 N까지 이동.
    
    0부터 시작.
*/
public class Solution {
    static class Step{
        int idx;
        int cost;
        
        public Step(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        
    }
    public int solution(int n) {
        
        int ans = 0;
        
        while(n != 0){
            
            if(n % 2 == 0) n = n/2;
            else{
                n-=1;
                ans++;
            } 
            
        }
        
        
        return ans;
    }


}