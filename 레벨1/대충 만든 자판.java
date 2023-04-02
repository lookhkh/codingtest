//https://school.programmers.co.kr/learn/courses/30/lessons/160586#
import java.util.Arrays;

class Solution {
    
    static int[] arr = new int[26];
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        
        Arrays.fill(arr,Integer.MAX_VALUE);
        
        
        for(String key : keymap){
            for(int i=0; i<key.length(); i++){
                int next = key.charAt(i) - 'A';
                
                if(arr[next] > i){
                    arr[next] = i+1;                    
                }
                
            }
        }
        
        answer = new int[targets.length];
        
        for(int i=0; i<targets.length; i++){
            
            String target = targets[i];
            int result = 0;
            boolean resultBoolean = true;
            for(int j=0; j<target.length(); j++){
                
                int idx = target.charAt(j)-'A';
                if(arr[idx] == Integer.MAX_VALUE) {
                    resultBoolean = false;
                    break;
                }
                else{
                    result+=arr[idx];
                }
                
            }
            
            if(result == 0 || !resultBoolean){
                answer[i] = -1;
            }else{
                answer[i] = result;
            }
            
        }
        
        return answer;
    }
}