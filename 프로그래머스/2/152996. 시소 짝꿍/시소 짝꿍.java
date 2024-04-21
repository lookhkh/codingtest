import java.util.*;
// 1 2/3 2/4 3/4 
class Solution {
    public long solution(int[] weights) {   
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> table = new HashMap<>();
        
        for(int weight : weights){
            
            double a1 = weight * 1.0;
            double a2 = weight * 2.0 / 3.0;
            double a3 = weight * 2.0 / 4.0;
            double a4 = weight * 3.0 / 4.0;
            
            answer+=table.getOrDefault(a1, 0);
            answer+=table.getOrDefault(a2, 0);
            answer+=table.getOrDefault(a3, 0);
            answer+=table.getOrDefault(a4, 0);
            
            table.put(a1, table.getOrDefault(a1,0)+1);
        }
        
        
        return answer;
    }
}