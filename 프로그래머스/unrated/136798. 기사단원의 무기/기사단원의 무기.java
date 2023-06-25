import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] nums = new int[number+1];
        
        for(int i=1; i<=number; i++){
            int next = i;
            int cnt = 0;
            for(int j=1; j*j<=next; j++){
                if(j * j == next) cnt++;
                else if(next % j == 0) cnt+=2;
            }
            
            nums[i] = cnt;
        }
        
        for(int w : nums){
          if(w > limit) {
              answer+=power;
          }else{
              answer+=w;
          }
        } 
        
        return answer;
    }
}