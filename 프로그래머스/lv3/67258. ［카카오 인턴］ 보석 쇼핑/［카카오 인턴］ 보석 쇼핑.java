import java.util.*;
class Solution {
    Set<String> set;
    int initSize;
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        set = new HashSet<>();
        
        for(String gem : gems){
            set.add(gem);
        }
        initSize = set.size();
        
        int currentIdx = 0;
        
        System.out.println(set);
        
        set.remove(gems[0]);
        
        System.out.println(set);
        
        return answer;
    }
}