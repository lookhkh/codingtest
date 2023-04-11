//https://school.programmers.co.kr/learn/courses/30/lessons/131701

import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++){
            
            for(int idx=0; idx<elements.length; idx++){
                
                int cnt = 0;
                int sum = 0;
                while(cnt < i){
                    sum += elements[(idx+cnt) % elements.length];
                    cnt++;
                }
                
                set.add(sum);
                
            }
            
        }
        
        
        return set.size();
    }
}