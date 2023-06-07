class Solution {
    int k =0;
    public int solution(int[] stones, int w) {
        int answer = 0;
        k = w;
        int left = 1;
        int right = 200_000_000;
        
        while(left <= right){
            
            int mid = (left + right)/2;
            
            boolean isOkay = check(stones, mid);
            if(isOkay){
                left = mid+1;
                answer = Math.max(mid,answer);
            }else{
                right = mid-1;
            }
            
        }
        
        
        return answer;
    }
    
    public boolean check(int[] stones, int mid){
        int remain = k;
       
        for(int i=0; i<stones.length; i++){
            int next = stones[i];
            
            if(next < mid){
                if(remain > 0) {
                    remain--;
                    if(remain == 0) return false;
                    continue;
                }else{
                    return false;
                }
            }else{
                remain = k;
            }
            
        }
        
        return true;
        
    }
}