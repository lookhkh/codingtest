/*
    길이가 같은 두 개의 큐.
    하나의 큐에서 pop =>> 다른 큐에 insert
    
*/
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        long tempSum = 0;
        long tempSum1 = 0;
        long tempSum2 = 0;
        for(int i=0; i<queue1.length; i++){
            que1.add(queue1[i]);
            tempSum1+=queue1[i];
        }
        
        for(int i=0; i<queue2.length; i++){
            que2.add(queue2[i]);
            tempSum2+=queue2[i];
        }
        
        tempSum = tempSum1+tempSum2;
        
        if(tempSum % 2 !=0) return -1;
        
        tempSum /= 2;

        for(int i=0; i<100_000_000; i++){
            
            if(tempSum1 == tempSum2) return answer;
            
            if(tempSum1 > tempSum){
                answer++;
                int p = que1.poll();
                tempSum1-=p;
                tempSum2+=p;
                que2.add(p);
            }else{
                answer++;
                int p = que2.poll();
                tempSum2-=p;
                tempSum1+=p;
                que1.add(p);
            }
            
            
        }
        return -1;
    }
}