/**
1. 이미 처리중인 작업이 있다면, 대기해야 한다.
2. 처리 중인 작업이 없다면 바로 실행한다.
**/
import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.ingest, t2.ingest));
        int answer = 0;
        for(int[] job : jobs){
            Job next = new Job(job[0], job[1]);
            que.add(next);
        }
        
        PriorityQueue<Job> buffer = new PriorityQueue<>((t1,t2)->Integer.compare(t1.duration, t2.duration));
        
        int cnt = 0;
        Job currentJob =null;
        
        for(int t=0; cnt < jobs.length; t++){
            
            if(currentJob == null){
                
                while(!que.isEmpty() && que.peek().ingest <= t){
                    buffer.add(que.poll());
                }
    
                if(buffer.isEmpty()) continue;
                                
                currentJob = buffer.poll();
                currentJob.set(t);     
               
            }

            if(currentJob == null || !currentJob.isEnd(t)) continue;
                
            System.out.println(currentJob+" is done");
            cnt++;
            answer+=currentJob.calc();
            currentJob = null;
            t--;
        
        }
        
        
        return answer / jobs.length;
    }
}

class Job{
    
    int ingest;
    int processing;
    int duration;
    
    public Job(int ingest, int duration){
        this.ingest = ingest;
        this.duration = duration;
    }
    
    public void set(int curTime){
        this.processing = curTime;
    }
    
    public boolean isEnd(int curTime){
        return (this.processing+ this.duration) <= curTime;
    }
    
    public int calc(){
        return (this.processing - this.ingest)+this.duration;
    }
    

    
    @Override
    public String toString(){
        return this.ingest+" curJob "+this.processing+" "+this.duration;
    }
}