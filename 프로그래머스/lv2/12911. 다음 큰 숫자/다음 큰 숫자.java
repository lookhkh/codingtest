class Solution {
    public int solution(int n) {
        
        int originalBitCnt = Integer.bitCount(n);
        
        int next = n;
        
        while(true){
            
            next+=1;
            int tempCnt = Integer.bitCount(next);
            
            if(tempCnt == originalBitCnt) return next;
            
        }

    }
    
  
}