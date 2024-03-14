class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        
        char[] ss = s.toCharArray();
        
        for(char sss : ss){
            if(sss == 'p' || sss =='P') p++;
            if(sss == 'y' || sss =='Y') y++;
        }
        
        
        return p == y;
    }
}