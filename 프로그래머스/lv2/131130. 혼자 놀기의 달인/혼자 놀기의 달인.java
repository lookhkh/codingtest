/*
`1~100까지의 카드.

*/
import java.util.*;
class Solution {
    
    public int solution(int[] cards) {
     
        int answer = 0;
        
        for(int i=0; i<cards.length; i++){
            
            boolean[] ch = new boolean[cards.length];
            
            int result = find(i,cards,ch);
            
            for(int j=0; j<cards.length && i!=j; j++){
                
                int secondResult = find(j, cards,ch);
                answer = Math.max(answer,result * secondResult);

            }
                        
        }
        
        
        return answer;
        
    }
    
    public int find(int idx, int[] cards, boolean[] ch){
        
        if(ch[idx]) return 0;
        ch[idx] = true;
        return 1+find(cards[idx]-1, cards, ch);
        
    }
}