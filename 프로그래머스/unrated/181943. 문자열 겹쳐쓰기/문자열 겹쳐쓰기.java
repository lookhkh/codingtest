class Solution {
    public String solution(String m, String w, int s) {
        String answer = "";
        m = m.substring(0,s)+w+m.substring(s+w.length());
        return m;
    }
}