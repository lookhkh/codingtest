import java.util.Arrays;
class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] r = String.valueOf(n).toCharArray();
        
        Arrays.sort(r);
        
        String t = "";
        for(int i=r.length-1; i>=0; i--){
            t+=r[i];
        }
        
        return Long.valueOf(t);
    }
}