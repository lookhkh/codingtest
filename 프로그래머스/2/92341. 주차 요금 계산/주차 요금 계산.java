/**
1. 입차 후, 출차 기록이 없다면, 23시59분에 출차된 것으로 간주한다.

**/
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> times = new HashMap<>();
        Map<String, Integer> lastCheck = new HashMap<>();
        
        for(String record : records){
            
            String[] r = record.split(" ");
            String time = r[0];
            String num = r[1];
            String type = r[2];
            
            if(type.equals("IN")) lastCheck.put(num, convert(time));
            else{
                times.put(num, convert(time) - lastCheck.get(num) + times.getOrDefault(num,0));
                lastCheck.remove(num);
            }
        }
        
        if(!lastCheck.isEmpty()){
            
            List<String> keys = new ArrayList<>(lastCheck.keySet());
            for(String key : keys){
                int plusTime = convert("23:59") - lastCheck.get(key);
                times.put(key, times.getOrDefault(key,0)+ plusTime);
            }
            
        }
        
        List<String> keys = new ArrayList<>(times.keySet());
        keys.sort((t1,t2)->Integer.compare(Integer.parseInt(t1), Integer.parseInt(t2)));
        
        int[] answer = new int[keys.size()];
        int idx = 0;
        for(String key : keys){
            int wholeTime = times.get(key);
            int exceed = (wholeTime - fees[0]);
            int result = exceed / fees[2];
            System.out.println(key+" "+wholeTime);
            if(exceed % fees[2] != 0)  result+=1;
            if(wholeTime < fees[0]) result = 0;
            answer[idx++] = fees[1]+ result * fees[3]; 
            
            
        }

        
        
        return answer;
    }
    
    int convert(String time){
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        
        return hour * 60 + min;
        
        
    }
}