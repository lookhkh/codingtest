class Solution {
    public int solution(String s) {
        int answer = 0;
        
        
        char default_val = ' ';
        char previous = default_val;
        int cntOfX = 0;
        int cntOfNotX = 0;
        
        for(int i=0; i<s.length(); i++){
            
            char next = s.charAt(i);
            
            if(previous == default_val) {
                previous = next;
                cntOfX+=1;
            } else{
                
                if(next == previous){
                    cntOfX ++;
                }else{
                    cntOfNotX ++;
                }
                
                if(cntOfX == cntOfNotX){

                    cntOfX = 0;
                    cntOfNotX = 0;
                    previous = default_val;
                    answer ++;
                }
                
                
                
            }
            
                if(i == s.length()-1){
                    if(cntOfX != cntOfNotX) answer++;
                }
            
            
        }
        
        return answer;
    }
}