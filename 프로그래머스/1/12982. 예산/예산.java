import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Solution {
    public int solution(int[] d, int budget) {
       
        Arrays.sort(d);
        
        int ans = 0;
        long sum = 0;
        for(int i=0; i<d.length; i++){
            
            if(sum + d[i] <= budget){
                ans++;
                sum+=d[i];
            }
            
        }
        
        return ans;
        
    }
}