/*
    선행스킬  => 어떤 스킬을 배우기 전 먼저 배워야 하는 스킬.
    스킬은 알파벳 대문자로만 이루어 짐.
    완전탐색으로 가능할 것으로 보임.
*/
import java.util.*;
import java.lang.StringBuilder;
class Solution {
    
    public int solution(String skill, String[] skill_trees) {
        int[] arr= new int[26];
        
        for(int i=0; i<skill.length(); i++){
            char n = skill.charAt(i);
            arr[n-'A'] = 1;
        }
        
        
        int answer = 0;

        for(String tree: skill_trees){
            
            StringBuilder b = new StringBuilder();
            
            for(int i=0; i<tree.length(); i++){
                char n = tree.charAt(i);
                if(arr[n-'A'] > 0) b.append(n);
            }
            
            String result = b.toString();
                        
            boolean isEqual = true;
            for(int i=0; i<result.length(); i++){
                if(result.charAt(i)!=skill.charAt(i)){
                    isEqual = false;
                    break;
                }
            }
            
            if(isEqual) {
                System.out.println(result);
                answer++;
            }
        }
        
        
        
        
        return answer;
    }
}