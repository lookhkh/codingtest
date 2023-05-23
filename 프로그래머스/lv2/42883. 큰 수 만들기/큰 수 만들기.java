import java.lang.StringBuilder;
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int targetSize = number.length() - k;
        
        while(targetSize > 0){
            
            int maxIdx = 0;
            char max = '0';
            
            for(int i=0; i<=number.length() - targetSize; i++){
                if(number.charAt(i) > max){
                    maxIdx = i;
                    max = number.charAt(i);
                    if(max == '9') break;
                }
            }
            
            answer.append(number.charAt(maxIdx));
            number = number.substring(maxIdx+1);
            
            targetSize--;
        }
        
     
        
        
        return answer.toString();
    }
}