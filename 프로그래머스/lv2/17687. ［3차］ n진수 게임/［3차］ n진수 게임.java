/*
    n진법 게임
    한 턴에 하나의 기호만을 출력한다. 
    즉, 10일 경우, 1,0 처럼
    
*/
import java.lang.StringBuilder;
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        int cur = 0;
        int nextNum = 0;
        int turn = 1;
        while(cur < t){
            
            String nw = getNth(nextNum, n);
            nextNum++;
            for(int i=0; i<nw.length() && cur < t; i++){
                char nextOne = nw.charAt(i);
                
                if(turn == p) {
                    answer.append(nextOne);
                    cur++;    
                }
                
                turn++;
                if( turn > m) turn = 1;
            }
            
        }
        
        
        return answer.toString();
    }
    
    public String getNth(int n, int k){
        if(n == 0) return "0";
        if(n < k  ) {
            if(k >= 11) return get16Th(n);
            return String.valueOf(n);
        }
        if(k < 10) return  getNth((n/k),k)+(n%k);
        else return getNth((n/k),k)+get16Th((n%k));
    }
    
    public String get16Th(int n){
        if(n < 10) return String.valueOf(n);
        if(n == 10) return "A";
        if(n == 11) return "B";
        if(n == 12) return "C";
        if(n == 13) return "D";
        if(n == 14) return "E";
        return "F";
    }
}