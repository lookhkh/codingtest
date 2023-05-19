/*
    셀수있는 수량, 순서 있는 요소의 모음 => 튜플
    n개의 요소를 가진 튜풀 =? n-튜풀
    
    1. 길이는 5~1,000,000
    2. 숫자가 0으로 시작하는 경우X
    3. 중복되는 원소가 없는 튜플
    
    튜플을 집합으로 표현할 때, 집합의 순서는 튜풀의 실제 순서와는 상관없음.
    ex) (1,2,3)
    => {3,2,1},{2,3}
    (1,2,3)
    
    {2,1}
    {3,2,1}
    
*/
import java.util.*;
import java.lang.StringBuilder;

class Solution {
    
    int[] nums;
    public int[] solution(String s) {
        int[] answer = {};
        
        nums = new int[100_001];
        
        s = s.substring(1,s.length()-1);
                
        List<String> list = getStringArr(s);
        
        list.sort((t1,t2)->Integer.compare(t1.split(",").length,t2.split(",").length));
        
        
        answer = new int[list.size()];
        
        int nextIdx = 0;
        
        for(int i=0; i<list.size(); i++){
            
            String[] next = list.get(i).split(",");
            
            for(int j=0; j<next.length; j++){
                
                int num = Integer.valueOf(next[j]);
                if(nums[num] == 0){
                    nums[num] = 1;
                    answer[nextIdx++] = num;
                }
                
            }
            
        }
        
        
  
        return answer;
    }
    
    public List<String> getStringArr(String s){
        
        List<String> list = new ArrayList<>();
       
        int idx = 0;
        
        while(idx<s.length()){
            
            char next = s.charAt(idx++);
            
            if(next == '{'){
                
                StringBuilder b = new StringBuilder();
                
                while(idx < s.length()){
                    
                    char nextSubChar = s.charAt(idx++);
                    
                    if(nextSubChar == '}') break;
                    
                    b.append(nextSubChar);
                    
                }
                
                list.add(b.toString());
            }
            
        }
        
        return list;
    }
}