import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int size = progresses.length;
            
        int curIdx = 0;
        while(curIdx < size){
            for(int i=0; i<size; i++){
                progresses[i]+=speeds[i];
            }
            
            int cnt = 0;
            
            for(int i=curIdx; i<size; i++){
                int cur = progresses[i];
                if(cur >= 100) {
                    curIdx = i+1;
                    cnt++;
                }
                else break;
            }
            
            if(cnt >0) answer.add(cnt);
        }
        
        
        
        return answer;
    }
}