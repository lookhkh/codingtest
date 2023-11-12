class Solution {
    public boolean solution(String s) {
        
        int len = s.length();
        
        return (len == 4 || len == 6) && s.matches("\\d+") ;
    }
}