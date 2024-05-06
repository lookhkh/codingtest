import java.util.*;
class Solution {
    char[] mems = new char[]{'A','C','F','J','M','N','R','T'};
    int answer = 0;
    String[] data;
    public int solution(int n, String[] data) {
        this.data = data;
        dfs(0, new HashMap<Character, Integer>(), new boolean[8]);
        
        
        return answer;
    }
    
    void dfs(int idx, Map<Character, Integer> results, boolean[] his){
        if(idx == mems.length){
            for(String next : data){
                
                if(!oper(next, results)) return;
                
            }
            
            answer++;
            
        }else{
            
            for(int i=0; i<mems.length; i++){
                if(his[i]) continue;
                his[i] = true;
                results.put(mems[i], idx);
                dfs(idx+1, results, his);
                
                his[i] = false;
            }
            
        }
        
    }
    
    boolean oper(String data, Map<Character, Integer> results){
        
        char start = data.charAt(0);
        char end = data.charAt(2);
        char operation = data.charAt(3);
        int target = data.charAt(4)-'0';
        
        int diff = Math.abs(results.get(start)- results.get(end)) -1 ;
        if(operation == '=') return diff == target;
        else if(operation == '>') return diff > target;
        return diff < target;
    }
}