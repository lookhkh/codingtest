import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        
        Subject[] subjects = Arrays.stream(plans)
            .map(t->new Subject(t[0], t[1], Integer.parseInt(t[2])))
            .sorted((t1,t2)->Integer.compare(t1.startTime, t2.startTime))
            .toArray(Subject[]::new);
        
        List<String> c = new ArrayList<>();
        
        Queue<Subject> que = new LinkedList<>();
        
        for(Subject s : subjects) que.add(s);
        
        Stack<Subject> stack = new Stack<>();
        
        while(!que.isEmpty()){
            
            Subject cur = que.poll();
            if(que.isEmpty()) c.add(cur.name);
            else{
                
                int duration = que.peek().startTime - cur.startTime;
                if(duration >= cur.remain){
                    duration-=cur.remain;
                    c.add(cur.name);
                    
                    while(duration > 0 && !stack.isEmpty()){
                        
                        Subject wait = stack.pop();
                        if(duration >= wait.remain){
                            c.add(wait.name);
                            duration -= wait.remain;
                        }else{
                            wait.remain -= duration;
                            duration = 0;
                            stack.push(wait);
                        }
                    }
                    
                }else{
                    
                    cur.remain-=duration;
                    stack.push(cur);
                    
                }
                
            }
            
        }
        
        while(!stack.isEmpty()){
            c.add(stack.pop().name);
        }
        
        return c.stream().toArray(String[]::new);
    }
}

class Subject{
    String name;
    int startTime;
    int remain;

    Subject(String name, String startTime, int remain){
        this.name = name;
        this.remain = remain;
        
        String[] arr = startTime.split(":");
        this.startTime += Integer.parseInt(arr[0]) * 60;
        this.startTime += Integer.parseInt(arr[1]) ;
    }
    
    @Override
    public String toString(){
        return this.name+" "+this.startTime+" "+this.remain;
    }
    
}