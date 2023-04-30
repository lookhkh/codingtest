
import java.util.Arrays;
import java.util.*;

class Solution {
    
    /*
        a : b = 1:1 => a = b  = b =a
        a : b = 2:1 => 2a = b  => b= 2a
        a : b = 3:2 => 3a = 2b; => b = 3/2 a
        a : b = 4:3 => 4a = 3b; => b = 4/3 a
    
    */
    
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        
        int[] map = new int[weights[weights.length-1]+1];
        
        for(int weight : weights){
            map[weight] += 1;
        }
        
        
       for(int i=0; i<weights.length; i++){
           
           int weight = weights[i];
           
           if(map[weight]!=1){
               answer += map[weight]-1;
               map[weight] -= 1;
           }
           
           if(weight * 2 < map.length &&  map[weight * 2] != 0){

                answer +=map[weight * 2];
            }
           
            double idx = weight * 3.0 / 2.0;
           
           if(idx % 1.0 == 0 && idx < map.length && map[(int)idx]!=0){

               answer+=map[(int)idx];
           }
           
           idx = weight * 4.0 / 3.0;
            
           if(idx % 1.0 == 0 && idx < map.length && map[(int)idx]!=0){

               answer+=map[(int)idx];
           }
           
           
       }
        
        
        return answer;
    }
}