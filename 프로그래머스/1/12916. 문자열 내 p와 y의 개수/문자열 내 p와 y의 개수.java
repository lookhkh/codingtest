class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s = s.toLowerCase();
        
        int pp = 0;
        int ss = 0;
        
        for(int i=0; i<s.length(); i++){
            char next = s.charAt(i);
            if(next == 'y') ss++;
            if(next == 'p') pp++;
        }
        
        
        
        return pp == ss;
    }
}