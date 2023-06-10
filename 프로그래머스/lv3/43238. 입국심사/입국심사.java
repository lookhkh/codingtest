import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long)times[times.length-1] * n;

        long answer = Long.MAX_VALUE;
        
        while(left <= right){
            
            long mid = (left + right) / 2;
            
            if(check(times, mid, n) >= n){
                right = mid-1;
                answer = Math.min(answer, mid);
            }else{
                left = mid+1;
            }
            
        }
        
        return answer;
    }
    public long check(int[] times, long mid, long n){
        
        long cnt = 0;
        
        for(int t : times){
            if(cnt >= n) return n;
            cnt += mid / t;
        }
        
        return cnt;
    }
}