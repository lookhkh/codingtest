class Solution {
    public long solution(long n) {
        long answer = 0;
        
        double r = Math.sqrt(n);
        if(r % 1.0 == 0){
            return (long)Math.pow((long)(r+1),2);
        }
        
        
        return -1;
    }
}