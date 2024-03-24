import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Status status = new Status(skill);
        
        for(String next : skill_trees){
            boolean result = true;
            
            for(char n : next.toCharArray()){
                if(status.contains(n)){
                    if(status.isRightOrder(n)) status.insert(n);
                    else{
                        result = false;
                        break;
                    }
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
    Queue<Character> pre;
    
    Status(String skill){
        this.skils = new HashMap<>();
        this.pre = new LinkedList<>();
        
        for(char next : skill.toCharArray()){
            skils.put(next, 1);
            pre.add(next);
        }
        
    }
    
    boolean contains(char ch){
        return skils.containsKey(ch);
    }
    boolean isRightOrder(char ch){
        return pre.peek() == ch;
    }
    void insert(char ch){
        pre.poll();
        pre.add(ch);
    }
    
    void reset(String str){
        this.pre = new LinkedList<>();
        for(char next : str.toCharArray()){
            pre.add(next);
        }
    }
}