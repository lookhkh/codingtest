//https://school.programmers.co.kr/learn/courses/30/lessons/176962#
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
   
    static class Job implements Comparable<Job>{
        String name;
        int startTime;
        int remain;
        
        public Job(String[] str){
            
            this.name = str[0];
            String[] time = str[1].split(":");
            this.startTime+= Integer.valueOf(time[0])*60+Integer.valueOf(time[1]);
            
            this.remain = Integer.valueOf(str[2]);
            
        }
        
        @Override
        public int compareTo(Job v1){
            return this.startTime - v1.startTime;
        }
        
        @Override
        public String toString(){
            return this.name+"  "+this.startTime+"  "+this.remain;
        }
    }
    
    public Job[] jobs;
    public Deque<Job> que;
    
     public String[] solution(String[][] plans) {
        
        int idx = 0;
        String[] answer = new String[plans.length];
        
        jobs = new Job[plans.length];
        que = new LinkedList<>();
        
        for(int i=0; i<plans.length; i++){
            jobs[i] = new Job(plans[i]);
        }
        
        Arrays.sort(jobs);
        
        Job prev = null;
        for(Job current : jobs){
            
            if(prev == null)  prev = current;
            else{
                
                int timeGap = current.startTime - (prev.startTime+prev.remain);
                if(timeGap < 0){
                    //이전 job을 마무리 못함
                    
                    prev.remain-=current.startTime - prev.startTime;
                    que.addFirst(prev);
                }else{
                    
                    answer[idx++] = prev.name;
                    while(timeGap>0 && !que.isEmpty()){
                        
                        Job ppp = que.peek();
                        
                        if( timeGap - ppp.remain >= 0 ){
                            timeGap -= ppp.remain;
                            que.pop();
                            answer[idx++] = ppp.name;
                          }else{
                            
                            ppp.remain -= timeGap;
                            timeGap = -1;
                                                    
                            
                        }
                        
                    }
                    
                }
                

            }
                prev = current;

        }
        answer[idx++] = prev.name;
        
        while(!que.isEmpty()) {
        	answer[idx++] = que.poll().name;
        }
        
        return answer;
    }
}