import java.util.*;

class Solution {
    
    static class Temp{
        int from;
        int to;
        int dis;
        
        public Temp(int from, int to){
            this.from = from;
            this.to = to;
            this.dis = ( to - from ) +1;
        }
        
    }
    
    List<Temp> list;
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        list = new ArrayList<>();
        
        
        int left = 0;
        long result = 0;
        
        for(int right=0; right<sequence.length; right++){
            
            result+=sequence[right];
            
            while(left<sequence.length && result >= k){
                
                if(result == k){
                    list.add(new Temp(left, right));
                }
                
                result-= sequence[left++];
                
            }
            
        }
        
        list.sort((t1,t2)->Integer.compare(t1.dis,t2.dis));
        
        answer[0] = list.get(0).from;
        answer[1] = list.get(0).to;

        
        return answer;
    }
}