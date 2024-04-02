import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        for(int i=1; i<=elements.length; i++){
            for(int x=0; x<elements.length; x++){
                int cnt = 0;
                int sum = 0;
                int idx = x;
                while(cnt < i){
                    cnt++;
                    sum+= elements[idx++];
                    if(idx >= elements.length) idx = 0;
                }
                answer.add(sum);
            }    
        }
        
        
        return answer.size();
    }
}