import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.Arrays;
class Solution {
    
    Map<String,Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            for(int j=0; j<orders.length; j++){
                int nextCourse = course[i];
                
                char[] arr = orders[j].toCharArray();
                Arrays.sort(arr);
                
                combination(nextCourse,0,0,new char[nextCourse], new String(arr));
            }
        }
        
        List<Entry<String,Integer>> pair = new ArrayList<>(map.entrySet());
        
        for(int c : course){
            
            List<Entry<String,Integer>> key = pair.stream()
                                             .filter(t->t.getKey().length() == c)
                                             .filter(t->t.getValue()>=2)
                                             .sorted((t1,t2)->Integer.compare(t2.getValue(), t1.getValue()) )
                                             .collect(toList());
            
            if(key.size()  <= 0 ) continue;
            
            int max = key.get(0).getValue();
            
            List<String> finalResult = key.stream()
                                          .filter(t->t.getValue() == max)
                                          .map(t->t.getKey())
                                          .collect(toList());
            
            answer.addAll(finalResult);
            }
        
        answer.sort(null);
        
        return answer.stream().toArray(String[]::new);
    }
    
    public void combination(int courseNum, int currentNum, int idx, char[] result, String source){
        if(courseNum == currentNum){
            
            String newString = new String(result);
            map.put(newString, map.getOrDefault(newString,0)+1);
        }else{
            
            for(int i=idx; i<source.length(); i++){
                result[currentNum] = source.charAt(i);
                combination(courseNum,currentNum+1,i+1,result,source);
            }
            
        }
    }
}