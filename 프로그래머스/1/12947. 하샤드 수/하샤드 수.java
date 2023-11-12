class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int result = get(x);
        
        if(x % result == 0) return true;
        
        return false;
    }
    
    public int get(int x){
        
        int sum = 0;
        while(x != 0){
            
            int digit = x % 10;
            sum += digit;
            x /= 10;
            
        }
        return sum;
        
    }
}