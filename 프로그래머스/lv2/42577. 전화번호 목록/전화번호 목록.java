/*
    입력값 중, 어떤 번호가 다른 번호의 접두어가 되는 경우가 있으면 false, 없으면 true 반환
    입력값은 최대 1_000_000개
    
    전화번호 중 중복되는 것은 없다.
    
    
*/
import java.util.*;
import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> set = new HashSet<>();
        Arrays.sort(phone_book, (t1,t2)->Integer.compare(t1.length(),t2.length()));
        
        for(String next : phone_book){
            
            for(int i=0; i<next.length(); i++){
                if(set.contains(next.substring(0,i+1))) return false;
            }
            
            set.add(next);
            
        }        
        
        return true;
    }
}