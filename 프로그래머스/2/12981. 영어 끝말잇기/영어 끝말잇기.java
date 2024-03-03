import java.util.*;
class Solution {
    
    Set<String> used = new HashSet<>();
    
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int idx = 0;
        int wordsIdx = 0;
        int cnt = 1;
        boolean result = true;
        
        String previous = null;
        while(wordsIdx < words.length){
            String nextWord = words[wordsIdx++];

            if(previous != null){
                if(previous.charAt(previous.length()-1)!=nextWord.charAt(0)) {
                    result = false;
                    break;
                }
                
                if(used.contains(nextWord)){
                    result = false;
                    break;
                }
            }
            
            used.add(nextWord);
            previous = nextWord;
            idx = (idx + 1) % n;
            if(idx == 0) cnt++;

        }
        
        if(result) return new int[]{0,0};
        answer[0] = idx+1;
        answer[1] = cnt;
        

        return answer;
    }
}