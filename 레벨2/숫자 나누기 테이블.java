//https://school.programmers.co.kr/learn/courses/30/lessons/135807

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class Solution {
    
    int max = 0;
    
    public int solution(int[] arrayA, int[] arrayB) {
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int minA = arrayA[0];
        int minB = arrayB[0];
        
        if(minA == minB) return 0;
      
        List<Integer> groupA = new ArrayList<>();
        List<Integer> groupB = new ArrayList<>();

        for(int i=2; i<=100_000_001; i++){
            
           if(i > minA && i > minB) break;
            
           int a = minA % i;
           int b = minB % i;
            
           if(a == b) {
               continue;
           }else{
               if(a == 0) groupA.add(i);
               if(b == 0) groupB.add(i);
           }
         
        }
        
        
        check(groupA, arrayA, arrayB);
        check(groupB, arrayB, arrayA);
        
        return max;
    }
    
    public void check(List<Integer> group, int[] array, int[] arrayNot){
        for(int i=0; i<group.size(); i++){
            
            int nextIdx = group.get(i);
            boolean result = true;
            
            
            for(int j=0; j<arrayNot.length; j++){
                int next = arrayNot[j];
                if(next % nextIdx == 0){
                    result= false;
                    break;
                }
            }
            
            
            if(!result) continue;
            
            for(int j=0; j<array.length; j++){
                
                int next = array[j];
                if(next % nextIdx != 0) {
                    result = false;
                    break;
                }
                
            }
            
            if(result) max = Math.max(max,nextIdx);
            
        }
    }
}