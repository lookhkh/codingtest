/*
    요금표, 입차/출차 기록
    차량별 주차요금 계산...
    
    1. 어떤 차량이 입차된 후, 출차된 내역이 없다면,,, 23:59 출차된 것으로 간주
    2. 초과한 시간이 단위 시간으로 나누어 떨어지지 않으면, 올림?
     [ a ] : a보다 작지 않은 최소의 정수
     
     
    차량별 누적 주차시간을 게산 및, 요금 일괄 계산.
*/
import java.util.*;

class Solution {
    
    static class Pair{
        int startTime;
        int endTime;
        
        public Pair(int startTime){
            
            this.startTime = startTime;
            this.endTime = -1;
        
        }
       
        public void insertEndTime(int time){
            this.endTime = time;
        }
        
          public void insertEndTime(){
            this.endTime = 60*23+59;
        }
        
        public int getSum(){
            return this.endTime - this.startTime;
        }
        
        public boolean isNotYetOut(){
            return this.endTime == -1;
        }
        
        @Override
        public String toString(){
            return this.startTime+"  "+this.endTime;
        }
       
    }
    
    String IN = "IN";
    String OUT = "OUT";
    
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, List<Pair>> list = new HashMap<>();
        
        for(String record : records){
            
            String[] meta = record.split(" ");
            String type = meta[2];
            int carNum = Integer.valueOf(meta[1]);
            int time = invertToInteger(meta[0]);
            
            if(type.equals(IN)){
                
                if(!list.containsKey(carNum)) list.put(carNum, new ArrayList<>());
                list.get(carNum).add(new Pair(time));
                
            }else{
                
                List<Pair> lists = list.get(carNum);
                
                for(int i=0; i<lists.size(); i++){
                    Pair temp = lists.get(i);
                    if(temp.endTime == -1) {
                        temp.insertEndTime(time);
                        break;
                    }
                }
                
            }
            
        }
        
        List<Integer> keys = new ArrayList<>(list.keySet());
        int[] answer = new int[keys.size()];

        keys.sort((t1,t2)->Integer.compare(t1,t2));
        
        for(int i=0; i<keys.size(); i++){
             int nextKey = keys.get(i);
             List<Pair> r = list.get(nextKey);
            
             int cnt = 0;
            
             for(int j=0; j<r.size(); j++){
                 
                 Pair n = r.get(j);
                 if(n.isNotYetOut()) n.insertEndTime();
                 cnt+=n.getSum();
                 
             }
            
            
            int overTime = (cnt - fees[0]);
            if(overTime < 0) {
                answer[i] = fees[1];
                continue;
            }
            boolean isDivided = overTime % fees[2] == 0?true:false;
            
            int finalR = fees[1]+ ((cnt - fees[0]) / fees[2]) * fees[3];
            
            if(!isDivided) finalR += fees[3];
            
            answer[i] = finalR;
            
            
        }
        
        
        return answer;
    }
    
    public int invertToInteger(String time){
        
        String[] arr = time.split(":");
        return Integer.valueOf(arr[0])*60+Integer.valueOf(arr[1]);
        
    }
}