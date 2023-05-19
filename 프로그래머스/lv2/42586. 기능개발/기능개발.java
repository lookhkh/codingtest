/*
    기능은 100% 일 때 서비스 가능.
    각 기능의 개발속도는 다르며, 완성 시기가 다를 수 있음.
    뒤에 있는 기능은, 앞에 있느 기능이 완료된 이후에 함께 배포 가능.
    
*/
import java.util.*;
class Solution {
    static class Service{
        int progress;
        int speed;
        
        public Service(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }
        
        public void up(){
            if(this.progress > 100) return;
            this.progress+=this.speed;
            if(this.progress > 100) this.progress = 100;
        }
        
        public boolean isDone(){
            return this.progress == 100;
        }
    }
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[5];
        
        Deque<Service> que = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            Service s = new Service(progresses[i],speeds[i]);
            que.add(s);
        }
                
        List<Integer> result = new ArrayList<>();
    
        while(!que.isEmpty()){
            
            int size = que.size();
            
            for(int i=0; i<size; i++){
                Service n = que.poll();
                n.up();
                que.addLast(n);
            }
            
            int cnt = 0;
            while(!que.isEmpty() && que.peek().isDone()){
                que.poll();
                cnt++;
            }
            
            if(cnt>0) result.add(cnt);
            
        }        
        
        return result.stream()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}