class Solution {
    public long solution(int a, int b) {
        
        if(a == b) return a;
        long left = a>b? getLong(b) : getLong(a);
        long right = a>b? getLong(a) : getLong(b);
        
        long n = (right - left +1);
        
        return ((n)*(left+right)) / 2;
    }
    
    public long getLong(int x){
        return Long.valueOf(x);
    }
}