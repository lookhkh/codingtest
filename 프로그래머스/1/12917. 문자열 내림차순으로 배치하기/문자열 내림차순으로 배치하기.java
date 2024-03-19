import java.util.*;
class Solution {
    public String solution(String s) {
        char[] arrs = s.toCharArray();
        Arrays.sort(arrs);
        return new StringBuilder(new String(arrs)).reverse().toString();
    }
}