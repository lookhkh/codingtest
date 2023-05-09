import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(s/n == 0){   
            return new int[]{-1};
        }
        
        
        for(int i=0; i<answer.length; i++){
                answer[i] = s / n;
        }
       
        int remain = s % n;
            
        int idx = 0;
        
        while(remain > 0){
                answer[idx++]+=1;
                remain--;
                
                if(idx >= answer.length){
                    idx = 0;
                
                }
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}