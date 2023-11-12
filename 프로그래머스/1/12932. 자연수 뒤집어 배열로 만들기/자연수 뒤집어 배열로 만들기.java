import java.lang.StringBuilder;

class Solution {
    public int[] solution(long n) {
        int[] answer = {};
        
        StringBuilder b = new StringBuilder(String.valueOf(n));
        b = b.reverse();

        char[] chars = b.toString().toCharArray();
        
        answer = new int[chars.length];
        
        for(int i=0; i<chars.length; i++){
            int next = Integer.valueOf(chars[i]-'0');
            answer[i] = next;
        }
        
        return answer;
    }
}