/*
    무손실 압축 알고리즘(LZW) 구현
    
    
*/
import java.util.*;
class Solution {
    
    Map<String,Integer> dict;
    
    int nextDictIdx = 27;
    
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        dict = new HashMap<>();
        
        for(char i ='A'; i<='Z'; i++){
            dict.put(String.valueOf(i),i-'A'+1);
        }
        
        while(msg.length()>0){
            
            int i = 1;
            
            for(; i<=msg.length(); i++){
                String temp = msg.substring(0,i);

                if(!dict.containsKey(temp)){
                    dict.put(temp,nextDictIdx++);
                    break;
                }
            }
            
            answer.add(dict.get(msg.substring(0,i-1)));
            msg = msg.substring(i-1);
            
            
        }
       
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}