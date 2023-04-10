//https://school.programmers.co.kr/learn/courses/30/lessons/131704

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] order) {
       
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=1; i<=order.length; i++){
            que.add(i);
        }

        for(int i=0; i< order.length; i++){
            
            int nextOrder = order[i];

            if(!que.isEmpty() && que.peek() == nextOrder){
                que.poll();
                answer++;
            }else{
                
                if(!stack.isEmpty() && stack.peek() == nextOrder){
                    stack.pop();
                    answer++;
                    continue;
                }else if(stack.isEmpty() || stack.peek() != nextOrder){
                    
                    if(que.isEmpty()) break;
                    
                    while(!que.isEmpty()){
                        
                        int nextQue = que.poll();
                        if(nextQue == nextOrder){
                            answer++;
                            break;
                        }else{
                            stack.push(nextQue);
                        }
                    }
                                        
                }
                
                
            }


        }
        

        
        return answer;
    }
}