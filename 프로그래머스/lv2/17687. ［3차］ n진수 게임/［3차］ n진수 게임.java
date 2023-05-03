import java.util.*;

class Solution {
    
    Map<Integer,String> code;
    
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        code = new HashMap<>();
        
        code.put(10,"A");
        code.put(11,"B");
        code.put(12,"C");
        code.put(13,"D");
        code.put(14,"E");
        code.put(15,"F");

        
       
        
        
        int currentNumber = 0;
        int currentIdx = 0; 
        int cnt = 0;
        
        while(cnt < t){
            
            String next = getNdix(n,currentNumber++,"");
            
            if(next.length() != 1 && next.startsWith("0")) next= next.substring(1);
            
            for(int i=0; i<next.length() && cnt < t; i++){
                                
                if(currentIdx % (m) == p-1){
                    answer+=next.charAt(i);

                    cnt++;
                }
                currentIdx++;
            }
            
            
        }
        
        
        
        return answer;
    }
    
    public String getNdix(int n, int target, String str){
        
        if(n == 10) return String.valueOf(n);
        if(target == 1) return "1"+str;
        if(target == 0) return "0"+str;

        
        int remain = target % n;
        String w = "";
        if(remain < 10)  w = String.valueOf(remain);
        else w = code.get(remain);
          
        return getNdix(n,target / n, w+str);
        
        
        
    }
}