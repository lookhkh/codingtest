import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();
        StringBuilder b = new StringBuilder();
        int offset = -1;
        
        for(int i=0; i<chars.length; i++){
            char next = chars[i];
            if(next ==' ') {
                b.append(next);
                if(offset != -1) offset = -1;
            }
            else{
                if(offset == -1) offset = i;
                int idx = i - offset;
                if(idx == 0 || idx % 2 ==0){
                    if(!Character.isUpperCase(next)) b.append(String.valueOf(next).toUpperCase());
                    else b.append(next);
                }else{
                    if(Character.isUpperCase(next)) b.append(String.valueOf(next).toLowerCase());
                    else b.append(next);
                }
                
                
            }
        }
        
        return b.toString();
    }
}