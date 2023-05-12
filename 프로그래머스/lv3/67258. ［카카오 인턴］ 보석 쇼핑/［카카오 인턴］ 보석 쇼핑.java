import java.util.*;
class Solution {
    
    Map<String,Integer> map;
    
    int wholeGems;
    
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        int curMinLength = 100_000;   
        
        map = new HashMap<>();
        
        Set<String> set = new HashSet<>();
        
        for(String gem : gems){
            if(!map.containsKey(gem)){
                map.put(gem,0);
            }
        }
        
        wholeGems = map.keySet().size();

        int left = 0;
        
        for(int right = 0; right<gems.length; right++){
            
            plusOne(gems[right]);
            
            set.add(gems[right]);
            
        //System.out.println(map+"  "+haveAllGemKind+"  "+left+"  "+right);
            
             while(left<right && haveMoreThanOne(gems[left])){
                
                minusOne(gems[left++]);
                
            }
            
            int length = getLength(right, left);
            
            if(set.size() ==wholeGems && curMinLength > length){
                answer[0] = left+1;
                answer[1] = right+1;
                curMinLength = length;
            }
            
            if(curMinLength == wholeGems){
                return answer;
            }
            
        }
     
        return answer;
    }
    
    public void plusOne(String target){
        map.put(target, map.get(target)+1);
    }
    
    public boolean haveMoreThanOne(String target){
        int r = map.get(target);
        return r>1;
    }
    
    public void minusOne(String target){
        map.put(target, map.get(target)-1);
    }
    
    public int getLength(int right, int left){
        return right - left+1;
    }
}