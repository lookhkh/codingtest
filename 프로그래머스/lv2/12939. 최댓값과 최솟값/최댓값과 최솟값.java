import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int[] strs = Arrays.stream(s.split(" "))
                           .mapToInt(Integer::valueOf)
                           .toArray();
        
        Arrays.sort(strs);
        
        answer+=strs[0];
        answer+=" ";
        answer+=strs[strs.length-1];
        
        
        return answer;
    }
}