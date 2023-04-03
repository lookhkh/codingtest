 //https://school.programmers.co.kr/learn/courses/30/lessons/154539#
import java.util.Stack;

class Solution {
    
    static class Node{
        int idx;
        int num;
        public Node(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
        
        @Override
        public String toString(){
            return this.idx+"  "+this.num;
        }
    }
    
    Stack<Node> stack;
    
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        stack = new Stack<>();
        
        
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            Node n = new Node(i,num);
            
            if(stack.isEmpty()) stack.push(n);
            else{
                                
                 while(!stack.isEmpty() && stack.peek().num < n.num){
                        
                        Node s = stack.pop();
                        
                        answer[s.idx] = n.num;
                        
                    }
                    
                stack.push(n);


            }
        }
        
        while(!stack.isEmpty()){
            Node n = stack.pop();
            answer[n.idx] = -1;
        }
        
        
        return answer;
    }
}