import java.util.*;
class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        PriorityQueue<Integer> target = new PriorityQueue<>();
        PriorityQueue<Integer> q1 = new PriorityQueue<>();

        for(int next : a) target.add(next);
        for(int next : b) q1.add(next);
        
        while(!target.isEmpty() && !q1.isEmpty()){
            
            int targetNum = target.poll();
            int q1Num = q1.poll();
            if(q1Num > targetNum) answer++;
            else{
                target.add(targetNum);
            }
        }

        
        // 1 3 5 7
        // 2 2 4 8 
        
        
        return answer;
    }
}