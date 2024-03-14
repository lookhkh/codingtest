import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String b = Integer.toString(n,3); 
        StringBuilder bb = new StringBuilder(b);
        bb.reverse();
        return Integer.parseInt(bb.toString(),3);
    }
}