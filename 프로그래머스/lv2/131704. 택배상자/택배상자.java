/*
    보조상자 => stack. 
    컨테이너 위에는 일렬로 택배가 온다.
    이때, 택배가 배달순서가 아닐 경우, 보조상자에 올려둔다.

*/
import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=1; i<=order.length; i++) que.add(i);
        
        for(int i=0; i<order.length; i++){
            
            int nextOrder = order[i];
                            
            if(!que.isEmpty() && que.peek() == nextOrder){
                que.poll();
                answer++;
                continue;
            }
            
           if(stack.isEmpty()) {
               if(!que.isEmpty()) {
                   stack.push(que.poll());
                   i--;
               }else{
                    break;
               }
           }else{
               
               if(stack.peek() == nextOrder){
                   stack.pop();
                   answer++;
                   continue;
               }else{
                   if(!que.isEmpty()){
                     stack.push(que.poll());
                     i--;
                   }else{
                       break;
                   }
               }
               
               
           }
            
            
            
            
        }
        
        
        return answer;
    }
}