import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        int whole = 0;
        while(!s.equals("1")){
            cnt++;
            int before = s.length();
            s = s.replaceAll("0","");
            int after = s.length();
            whole+=before - after;
            int c = s.length();
            s = Integer.toBinaryString(c);
            
        }
        
        ans.add(cnt);
        ans.add(whole);
        
        return ans.stream()
            .mapToInt(Integer::new)
            .toArray();
    }
}