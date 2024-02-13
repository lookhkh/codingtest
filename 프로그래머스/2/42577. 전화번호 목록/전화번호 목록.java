import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<String,Boolean> history = new HashMap<>();
        
        Arrays.sort(phone_book, (t1,t2)->Integer.compare(t1.length(), t2.length()));
        
        for(String next : phone_book){
            
            StringBuilder builder = new StringBuilder(next.length());
            for(char nextChar : next.toCharArray()){
                builder.append(nextChar);
                if(history.containsKey(builder.toString())) return false;
            }
            history.put(builder.toString(), true);
        }
        
        
        return true;
    }
}