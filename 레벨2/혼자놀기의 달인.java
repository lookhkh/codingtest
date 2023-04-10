//https://school.programmers.co.kr/learn/courses/30/lessons/131130

class Solution {
    
    int[] readCard;
    
    public int solution(int[] cards) {
        int answer = 0;
        readCard = cards;
        
        for(int nextCard=0; nextCard<cards.length; nextCard++){
            
            boolean[] ch = new boolean[cards.length];
            int result = find(nextCard,ch,0);
            
            if(result == cards.length) continue;
            for(int nNextCard = 0;nNextCard<cards.length && nNextCard != nextCard; nNextCard++ ){
                
                if(ch[nNextCard]) continue;
                int nextResult = find(nNextCard,ch,0);
                
                answer = Math.max(answer , result * nextResult);
            }
            
        }
        
        return answer;
    }
    
    public int find(int idx, boolean[] ch, int cnt){
    
        if(ch[idx]) return cnt;
        else{
            ch[idx] = true;
            return find(readCard[idx]-1,ch,cnt+1);
        }
    }
}