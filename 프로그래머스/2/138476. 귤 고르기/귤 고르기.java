import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] tangers = new int[10_000_001];
        
        for(int next : tangerine){
            tangers[next]+=1;
        }
        
        tangers = Arrays.stream(tangers).filter(t->t>0).toArray();
        Arrays.sort(tangers);
        
        
        for(int i=tangers.length-1; i>=0; i--){
            int num = tangers[i];
            answer++;
            k-=num;
            if(k <= 0) break;
        }
        
        return answer;
    }
}