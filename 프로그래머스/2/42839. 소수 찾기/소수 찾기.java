/**
7!
**/
import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        char[] nums = numbers.toCharArray();
        Set<String> list = new HashSet<>();
        dfs(0, "",nums, new boolean[nums.length] ,list);
        
        List<String> arr = new ArrayList<>(list);
        for(String next : arr){
            boolean r = isSosu(convert(next));
            if(r) answer++;
        }
        
        
        return answer;
    }
    
    int convert(String next){
        try{
            return Integer.parseInt(next);
        }catch(Exception e){
            return 0;
        }
    }
    
    boolean isSosu(int n){
        
        if(n == 1) return false;
        if(n == 0) return false;
        for(int i=2; i< n; i++){
            if(n % i == 0) return false;
        }
        
        return true;
    }
    
    void dfs(int curIdx, String str, char[] origin, boolean[] path, Set<String> list){
        if(str.startsWith("0")) str = str.substring(1, str.length());
        if(str.length() > 0) list.add(str);
      
            for(int i=0; i<origin.length; i++){
                
                if(path[i]) continue;
                path[i] = true;
                dfs(curIdx+1, str+origin[i], origin, path, list);
                path[i] = false;
                
            
        }
        
        
    }
}