class Solution {
    public int solution(int n) {
        int answer = 0;
        
        long nBits = getBits(n);
        
        int next = n;
        while(true){
            long nextBits = getBits(++next);
            if(nextBits == nBits) return next;
        }
        
        
    }
    
    public long getBits(int number){
        int count = 0;

        while (number != 0) {
            count += number & 1;  // Add the rightmost bit to the count
            number >>>= 1;       // Shift the number to the right by 1 bit
        }
        
        return count;

    }
}