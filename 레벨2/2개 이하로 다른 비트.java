//https://school.programmers.co.kr/learn/courses/30/lessons/77885#

class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            
            long target = numbers[i] ;
            
            if(target % 2 ==0) answer[i] = target+1;
            else{
                
                String str = Long.toBinaryString(target);
                if(str.contains("0")){
                    
                    int lastIdx = str.lastIndexOf("0");
                    str = str.substring(0,lastIdx)+"10"+str.substring(lastIdx+2);
                    
                }else{
                    str = "10"+str.substring(1);
                }
                
                long r = Long.parseLong(str, 2);
                answer[i] = r;

            }
        }
        
        
        return answer;
    }
    
}