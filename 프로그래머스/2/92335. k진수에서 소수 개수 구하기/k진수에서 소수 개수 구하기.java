import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String bin = convert(new StringBuilder(),k,n).reverse().toString();
    
        String[] arr = bin.split("0+");
        
        for(String next : arr){
            if(next.equals("")) continue;
            if(isPrime(Long.valueOf(next))){
                answer++;
            }
        }
        
        return answer;
    }
    
     public boolean isPrime(long n) {
        if(n == 1)  return false;
        long a = (long)Math.sqrt(n) + 1;
        for(int i=2;i<a;i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    
    StringBuilder convert(StringBuilder r , int k, int n){
        if(n < k){ 
            r.append(n);
            return r;
        }
        r.append(n%k);
        return convert(r, k, n/k);
    }
}