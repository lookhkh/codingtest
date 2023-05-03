import java.util.*;
/*
    1,2,3,4
    
    1,2,3,4
    1,2,4,3
    1,3,2,4
    1,3,4,2
    1,4,2,3
    1,4,3,2
    2,1,3,4,
    2,1,4,3
    2,3,1,4
    2,3,4,1
    2,4,1,3
    2,4,3,1
    3,1,2,4
    3,1,4,2,
    3,2,1,4
    3,2,4,1
    3,
*/
class Solution {

    List<Integer> list;
    List<Integer> eles;
    int original;
    public List<Integer> solution(int n, long k) {
        int[] answer = {};
        
        list = new ArrayList<>();
        
        eles = new ArrayList<>();
        
        original = n;
        
        for(int i=0; i<=n+1; i++){
            eles.add(i);
        }
        
        dp(k, n, 0,0);
        
        return list;
    }
    
    public void dp(long n, int length, int idx, long padding){
        
        if(idx > n) return;
        if(idx == original-1){
            list.add(eles.get(1));
            return;
        }
        if(length <= 0) return;
        
        long wholeCase = factorial(length);
       
        int i = 1;
        
        long subCase = wholeCase / length;
        
        for(; i<=length; i++){
            
            long eachSubcase = (subCase * i) + padding;
            
            if(n <= eachSubcase){
                
                padding += subCase * (i - 1);
                
                break;
            }
            
        }
        
        list.add(eles.get(i));
        eles.remove(i);
        
        dp(n, length-1, idx+1, padding);
        
        
    }
    
    public long factorial(int n){
    	if(n == 0) return 0;
        if( n == 1) return 1;
        return n * factorial(n-1);
    }


}