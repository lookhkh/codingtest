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
import static java.util.stream.Collectors.*;
import java.util.*;
import java.lang.StringBuilder;
import java.util.Arrays;

class Solution {
    
    public int[] solution(String s) {
        int[] answer = {};
                
        s = s.substring(1,s.length()-1);
                
        List<String[]> list = getStringArr(s);
        
        list.sort((t1,t2)->Integer.compare(t1.length,t2.length));
        
        answer = new int[list.size()];
        
        int nextIdx = 0;
        
        int[] nums = new int[100_001];

        for(int i=0; i<list.size(); i++){
            
            String[] next = list.get(i);
            
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
    
    public List<String[]> getStringArr(String s){
                
        s= s.replaceAll("\\{"," ").replaceAll("\\}"," ").trim();
        
        return  Arrays.stream(s.split(" , "))
                      .map(t->t.split(","))
                      .collect(toList());
        
    }
}