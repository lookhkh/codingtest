import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        int answer = Integer.MAX_VALUE;
        int len = s.length() / 2;
        
        for(int i=1; i<=len; i++){
            
            String r = compress(i, s);
            answer=Integer.min(r.length(), answer);
            
        }
        
        return answer;
    }
    
    String compress(int n, String s){
        
        StringBuilder ans = new StringBuilder();
        
        StringBuilder first = new StringBuilder(s.substring(0,n));
        int cnt = 1;
        
        StringBuilder temp = new StringBuilder();
        for(int i=n; i<s.length(); i++){
            if(temp.length() < n){
                temp.append(s.charAt(i));
            }
            
            if(temp.length() == n){
                if(equals(first, temp)){
                    cnt++;
                }else{
                    if(cnt > 1) ans.append(cnt);
                    ans.append(first.toString());
                    first = new StringBuilder(temp.toString());
                    cnt = 1;
                }
                    temp = new StringBuilder();

            }
        
            
        }
        
        if(cnt > 1) ans.append(cnt);
        ans.append(first.toString());
        if(temp.length() > 0) ans.append(temp);
        return ans.toString();
        
    }
    
    boolean equals(StringBuilder a, StringBuilder b){
        return a.toString().equals(b.toString());
    }
}