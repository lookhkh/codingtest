import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        DoubleQueue que = new DoubleQueue();
        
        for(String oper : operations){
            String[] arr = oper.split(" ");
            String command = arr[0];
            int target = Integer.parseInt(arr[1]);
            
            if(command.equals("I")){
                que.insert(target);
            }else{
                if(target == 1){
                    que.removeMax();
                }else{
                    que.removeMin();
                }
            }
        }
        
        return que.getResult();
    }
}

class DoubleQueue{
    
    PriorityQueue<Value> minQueue;
    PriorityQueue<Value> maxQueue;
    
    DoubleQueue(){
        this.minQueue = new PriorityQueue<>((t1,t2)->Integer.compare(t1.value, t2.value));
        this.maxQueue = new PriorityQueue<>((t1,t2)->Integer.compare(t2.value, t1.value));
    }
    
    void insert(int value){
        Value val = new Value(value);
        this.minQueue.add(val);
        this.maxQueue.add(val);
    }
    
       int removeMax(){
        while(!this.maxQueue.isEmpty()){
            Value val = this.maxQueue.poll();
            if(val.isRemoved && this.maxQueue.isEmpty()) return 0;
            if(val.isRemoved) continue;
            val.mark();
            return val.value;
        }
           return 0;
    }
    
       int removeMin(){
            while(!this.minQueue.isEmpty()){
                Value val = this.minQueue.poll();
                if(val.isRemoved && this.minQueue.isEmpty()) return 0;
                if(val.isRemoved) continue;
                val.mark();
                return val.value;
            }
           return 0;
        }
    
        int[] getResult(){
            int[] res = new int[2];
            res[1] = this.removeMin();
            res[0] = this.removeMax();
            return res;
        }
    
    
    
}

class Value{
    int value;
    boolean isRemoved;

    Value(int value){
        this.value = value;
        this.isRemoved = false;
    }
    
    void mark(){
        this.isRemoved = true;
    }
}