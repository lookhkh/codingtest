import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        for(int i=score.length-1; i>=0; i--){
            
            int next = score[i];
            min = Math.min(next, min);
            cnt++;
            
            if(cnt == m){
                answer+= min * cnt;
                cnt = 0;
                min = Integer.MAX_VALUE;
            }
            
        }
        
        return answer;
    }
}