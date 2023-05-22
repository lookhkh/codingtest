import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            
            if(stack.isEmpty()) stack.push(i);
            else{
                
                if(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                    
                    while(numbers[stack.peek()] < numbers[i]){
                        int idx = stack.pop();
                        answer[idx] = numbers[i];
                        
                        if(stack.isEmpty()) break;
                    }
                    
                }
                
                stack.push(i);
                
            }
            
        }
        
        while(!stack.isEmpty()){
            int n = stack.pop();
            answer[n] = -1;
        }
        
        return answer;
    }
}