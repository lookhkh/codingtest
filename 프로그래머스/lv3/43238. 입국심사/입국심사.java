import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        int max =times[times.length-1];
        
        long left = 1;
        long right = (long) max * n;
        
        long min = Long.MAX_VALUE;
        
        while(left <= right){
                
            long mid = left+(right - left) /2;
            if(check(mid, n, times)){
                
                right = mid-1;
                min = Math.min(min,mid);
                
            }else{
                left = mid+1;
            }
            
        }
        
        return min;
    }
    
    public boolean check(long k, long num, int[] times){
        long answer = 0;
        for(int i=0; i<times.length; i++){
            int next = times[i];
            answer+=  k / next;
        }
        
        if(answer >= num) return true;
        return false;
    }
}