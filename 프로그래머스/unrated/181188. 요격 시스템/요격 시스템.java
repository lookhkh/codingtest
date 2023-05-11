import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (t1,t2)->Integer.compare(t1[1],t2[1]));

        int[] last = null;
        for(int i=0; i<targets.length; i++){
            if(last == null){
                last = targets[i];
                answer++;
            }else{
                
                int[] cur = targets[i];
                
                if(last[1]<=cur[0]){
                    last = cur;
                    answer++;
                }
                
            }
        }
        
        return answer;
    }
}