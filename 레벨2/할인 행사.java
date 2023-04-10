//https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.Map;
import java.util.HashMap;

class Solution {
    
    static class Wrapper{
        Map<String,Integer> map;
        String[] want;
        int[] number;
        
        public Wrapper(String[] want, int[] number){
            this.map = new HashMap<>();
            this.want = want;
            this.number = number;
        }
        
        public void put(String name){
            this.map.put(name, this.map.getOrDefault(name,0)+1);
        }
        
        public void remove(String name){
            int nums = this.map.getOrDefault(name, 0);
            if(nums == 0) this.map.remove(name);
            else{
                this.map.put(name, nums-1);
            }
        }
        
        public boolean check(){
            
            for(int i=0; i<this.want.length; i++){
                int nextCnt = this.map.getOrDefault(want[i],0);
                if(nextCnt != this.number[i]) return false;
            }
            
            return true;
            
        }
        
        @Override
        public String toString(){
            return this.map.toString();
        }
        
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Wrapper wrapper = new Wrapper(want,number);
        
        for(int i=0; i<10; i++){
            wrapper.put(discount[i]);
        }
        
        if(wrapper.check()) answer++;
        
        for(int i=10; i<discount.length; i++){
            wrapper.remove(discount[i-10]);
            wrapper.put(discount[i]);

            if(wrapper.check()) answer++;
        }
        
      
        
        return answer;
    }
}