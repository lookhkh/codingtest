import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        
        long[] strs = Arrays.stream(s.split(" "))
                           .mapToLong(Long::valueOf)
                           .toArray();
        
        Arrays.sort(strs);
        
        answer+=strs[0];
        answer+=" ";
        answer+=strs[strs.length-1];
        
        
        return answer;
    }
}