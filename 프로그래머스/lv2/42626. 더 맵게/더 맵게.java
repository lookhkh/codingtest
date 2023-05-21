/*
    모든 음식의 스코빌 지수를 K이상으로 만들어야 한다.
    가장 지수가 낮은 것과, 그 다음으로 낮은 것을 섞는다.
    모든 음식이 스코빌 지수 이상일 때까지 반복.

*/
import java.util.*;
class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue();
        for(int t : scoville) que.add(t);
        
        while(!que.isEmpty() && que.peek() < k){
            
            answer++;
           
            if(que.size() >= 2){
                
                int first = que.poll();
                int second = que.poll();
                
                que.add(first+second*2);
                
            }
            
            if(que.size() == 1){
                if(que.peek() >= k) return answer;
                else return -1;
            }             
        }
        
        return answer;
    }
}