/*
    초 단위로 기록된 주식가격이 담긴 배열.
    가격이 떨어지지 않은 기간은 몇 초인가?
    만약 S[i]에서 S[i+1]에서 바로 떨어지면 1을 반환하며,
    뒤에 아무것도 없을 경우에는 0을 반환한다.
    Stack => 1. 자기보다 크거나 같은 게 올 경우에는 그냥 컷
             2. 최상단의 값보다 작은게 들어온다? 
                1 idx을 이용한다면? 
    
*/
import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        
        
        int[] answer = new int[prices.length];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<prices.length; i++){
            
            if(stack.isEmpty()) stack.push(i);
            else{
                
                int nextValue = prices[i];
                int topValue = prices[stack.peek()];
                
                if(topValue <= nextValue) stack.push(i);
                else{
                    
                    while(!stack.isEmpty() && prices[stack.peek()]>nextValue){
                        
                        int nextIdx = stack.pop();
                        answer[nextIdx] = i - nextIdx;
                        
                    }
                    
                    stack.push(i);
                    
                }
                
            }
            
        }
        
        System.out.println(stack);
        
        int lastOne = -1;
        
        while(!stack.isEmpty()){
            if(lastOne == -1) lastOne = stack.pop();
            else{
                
                int n = stack.pop();
                answer[n] = lastOne - n;
                
            }
        }
        
        return answer;
    }
}