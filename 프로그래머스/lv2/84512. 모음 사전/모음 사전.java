/*
    모음 " ",A,E,I,O,U 만을 이용하며 만들 수 있는 길이 5이하의 모든 단어가 수록된 사전.
    중복순열+공백.    
    
*/
import java.util.*;
import java.util.Arrays;

class Solution {
    
    Set<String> dict = new HashSet<>();
    List<Character> list = Arrays.asList('A','E','I','O','U');
    
    public int solution(String word) {
        int answer = 0;
        
        dfs(0,"");
        
        List<String> r = new ArrayList<>(dict);
        
        r.sort(null);
        
        for(int i=0; i<r.size(); i++){
            if(r.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public void dfs(int cnt, String result){
        if(cnt == 5){
            dict.add(result);
        }else{
            
             for(int i=0; i<list.size()+1; i++){
                 if(i<list.size()) dfs(cnt+1,result+list.get(i));
                 else dfs(cnt+1,result);
             }
            
        }
    }
}