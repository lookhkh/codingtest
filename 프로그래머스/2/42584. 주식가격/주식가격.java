import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Value> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            int val = prices[i];
                
            while(!stack.isEmpty() && !stack.peek().check(val)){
                Value top = stack.pop();
                answer[top.idx] = i - top.idx;                
            }
            stack.push(new Value(i,val));
                
        }
        
        while(!stack.isEmpty()){
            Value top = stack.pop();
            answer[top.idx] = (prices.length -1) - top.idx;
        }
        
        return answer;
    }
}

class Value{
    int value;
    int idx;
    Value(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
    boolean check(int value){
        return value >= this.value;
    }
}