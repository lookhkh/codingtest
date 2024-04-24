import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
       
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        
        return Math.max(find(arrayA, arrayB), find(arrayB, arrayA));
    }
    
    int find(int[] should, int[] notShould){
        
        int min = should[0];
        List<Integer> arr = yaksu(min);
        
        int max = 0;
        
        for(int next : arr){
            if(dividable(next ,should) && notDividable(next ,notShould)) max = Math.max(max, next);
        }
        
        return max;
    }
    
    boolean dividable(int num, int[] values){
        for(int next : values){
            if(next % num != 0) return false;
        }
        return true;
        
    }
    
     boolean notDividable(int num, int[] values){
        for(int next : values){
            if(next % num == 0) return false;
        }
        return true;
        
    }
    
    
    List<Integer> yaksu(int target){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i*i<=target; i++){
           if(target % i == 0) {
               list.add(i);
               list.add(target / i);
           }
        }
        list.add(target);
        return list;
        
    }
}