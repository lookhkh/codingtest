//https://school.programmers.co.kr/learn/courses/30/lessons/92335#

import java.lang.StringBuilder;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String converted = getK(n,k,"");
        String[] results = converted.split("0");
        System.out.println(converted);

        for(String result : results){
            if(result.equals("") || result.equals(" ")) continue;
            long intR = Long.valueOf(result);
            if(check(intR)) answer++;
        }
        
        
        return answer;
    }
    
    public boolean check(long r){
        if(r == 1) return false;
        if(r == 2 || r == 3) return true;
        
        for(int i=3; i<=Math.sqrt(r); i += 2) { 
        if( r % i == 0)
            return false;
        }
        
        return true;
        
        
    }
    
    public String getK(int n, int k, String result){
        if( n == 0){
            StringBuilder input = new StringBuilder();
            input.append(result);
            return input.reverse().toString();
        }else{
            int remain = n % k;
            return getK(n / k, k, result+remain);
        }
    }
}