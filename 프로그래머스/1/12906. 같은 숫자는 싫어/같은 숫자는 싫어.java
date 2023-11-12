import java.util.*;

public class Solution {
    public List<Integer> solution(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        
        int prev = -1;
        for(int i=0; i<arr.length; i++){
            int next = arr[i];
            
            if(prev == -1){
                prev = next;
                ans.add(prev);
                continue;
            } 
                
            if(prev == next) continue;
            
            i--;
            prev = -1;            
            
        }

        return ans;
    }
}