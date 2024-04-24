import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        Stack<Num> stack = new Stack<>();
        
        for(int num : numbers){
            
            while(!stack.isEmpty() && stack.peek().isBigger(num)){
                Num n = stack.pop();
                answer[n.idx] = num;
            }
            
            stack.push(new Num(idx++, num));
            
        }
        
        while(!stack.isEmpty()){
                Num n = stack.pop();
                answer[n.idx] = -1;
        }
        
        
        return answer;
    }
}

class Num{
    int idx;
    int num;
    Num(int idx, int num){
        this.idx = idx;
        this.num = num;
    }
    boolean isBigger(int num){
        return this.num < num;
    }
}