import java.util.*;
class Solution {
    final char[] arr = new char[]{'A','E','I','O','U'};
    Map<String, Integer> dict = new HashMap<>();
    int offset = 0;
    public int solution(String word) {
        dfs(0, "");
        
        return dict.get(word);
    }
    
    void dfs(int curIdx, String data){
        String str = new String(data);
        if(!dict.containsKey(str)) dict.put(str, offset++);

        if(curIdx == 5){
            return;
        } 
        for(int i=0; i<arr.length; i++){
            dfs(curIdx+1, data+arr[i]);
        }
    }
    
}