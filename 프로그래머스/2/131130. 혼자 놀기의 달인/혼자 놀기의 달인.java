import java.util.*;
class Solution {
    int max = 0;
    public int solution(int[] cards) {

        cards = Arrays.stream(cards).map(t->t-1).toArray();        
        for(int i=0; i<cards.length; i++){
            boolean[] his = new boolean[cards.length];
            dfs(0,i, cards,his, new int[2]);
        }
        
        return max;
    }
    void dfs(int cnt, int next, int[] cards, boolean[] his, int[] results){
        if(cnt == 2){
            this.max = Math.max(this.max, results[0] * results[1]);
        }else{
            
            int num = 0;
            int nextNum = next;
            while(true){
                
                if(his[nextNum]) break;
                int n = cards[nextNum];
                num++;
                his[nextNum] = true;
                nextNum = n;
                
            }
            
            results[cnt] = num;
            
            if(cnt == 1)  dfs(cnt+1,-1, cards,his, results);
                        
            for(int i=0; i<cards.length && !his[i]; i++){
                
                dfs(cnt+1,i, cards,his, results);
                
            }
            
        }
    }

}