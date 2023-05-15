import java.util.*;
import java.util.Arrays;

class Solution {
    int bus = 9*60;
    public String solution(int n, int ts, int m, String[] timetable) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        int[] table = Arrays.stream(timetable).mapToInt(t->{
                            String[] w = t.split(":");
                            int hour = Integer.valueOf(w[0])*60;
                            int minute = Integer.valueOf(w[1]);
                            return hour + minute;
                        }).toArray();

          for(int next : table){
              que.add(next);
          }
        
          for(int i=0; i<n; i++){
              if(i!=0) bus += ts;
              boolean isLast = i==n-1;
              
              if(!isLast){
                  
                  int cnt = m;
                  while(!que.isEmpty() && que.peek() <= bus && cnt > 0){
                        cnt--;
                        que.poll();
                  }
                  
              }else{
                  
                if(que.isEmpty() || que.peek() > bus || que.size() < m) {
                    answer = bus;
                    
                }
                if(que.peek() <= bus){
                      
                    if(que.size() < m) answer = bus;
                    else{
                        
                         List<Integer> temp = new ArrayList<>(que);
                         for(int w=temp.size()-1; w>=0; w--){
                             
                             int tempMax = temp.get(w)-1;
                             int rank = 0;
                             for(int z=0; z<temp.size(); z++){
                                 int target = temp.get(z);
                                 if(tempMax >= target) rank++;
                             }
                             
                             if(rank >=m) continue;
                             else{
                                 answer = Math.max(tempMax,answer);
                             }
                             
                         }
                        
                    }
                      /*
                        1. 08:59 09:00 09:01 09:02 m= 3
                        2. 09:00 09:00 09:00 09:00 m= 3 08:59
                        3. 08:59 09:00 09:01 09:01 n = 4 09:00
                      */
                    
                  }
                  
              }
              
          }
   
        System.out.println(answer);
        
        String hour = String.valueOf(answer / 60);
        String minute = String.valueOf(answer % 60);
        
        if(hour.length() == 1) hour="0"+hour;
        if(minute.length() == 1) minute ="0"+minute;
        return hour+":"+minute;
    }
}