import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = Arrays.stream(stones).max()
                .orElseThrow(NoSuchElementException::new);

        int answer = 0;
        
        while(left <= right){
            
            int mid = (left + right) / 2;
            if(check(stones, k, mid)){
                left = mid+1;
                answer = Math.max(answer, mid);
            }else{
                right = mid-1;
            } 
            
        }
        return answer;
    }
    
    boolean check(int[] stones, int k, int mid){
        
        int remain = k;
        
        for(int i=0; i<stones.length; i++){
            
            int next = stones[i];
            if(mid <= next){
                remain = k;        
            }else{
                remain-=1;
                if(remain <= 0) return false;

            }
            
        }
        
        return true;
        
    }

}