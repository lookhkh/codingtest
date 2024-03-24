import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Status status = new Status(skill);
        
        for(String next : skill_trees){
            boolean result = true;
            
            char[] arr = next.toCharArray();
            for(int i=0; i<arr.length && result; i++){
                char n = arr[i];
                if(!status.contains(n)) continue;
                if(status.isRightOrder(n)) status.insert(n);
                else{
                   result = false;
                }
            }
            
            if(result) answer++;
            status.reset(skill);
        }
        
        
        return answer;
    }
}

class Status{
    Map<Character,Integer> skils;
    char[] pre;
    int idx;
    
    Status(String skill){
        this.skils = new HashMap<>();
        this.pre = skill.toCharArray();
        this.idx = 0;    
        for(char next : skill.toCharArray()){
            skils.put(next, 1);
        }
        
    }
    
    boolean contains(char ch){
        return skils.containsKey(ch);
    }
    boolean isRightOrder(char ch){
        return this.pre[this.idx] == ch;
    }
    void insert(char ch){
        this.idx++;
    }
    
    void reset(String str){
        this.idx = 0;
    }
}