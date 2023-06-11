import java.util.Arrays;
class Solution {
    public int[] solution(long n) {
        String t = String.valueOf(n);
        StringBuilder b= new StringBuilder(t);
        String[] r = b.reverse().toString().split("");
       
        return Arrays.stream(r).mapToInt(Integer::valueOf).toArray();
        
    }
}