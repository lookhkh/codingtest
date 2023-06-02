class Solution {
    public String solution(String m) {
        
        m = m.replaceAll("a","").replaceAll("e","").replaceAll("i","").replaceAll("o","").replaceAll("u","");
        
        return m;
    }
}