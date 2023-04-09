//https://school.programmers.co.kr/learn/courses/30/lessons/132265
import java.util.Arrays;
import java.util.Stack;

import java.util.Map;
import java.util.HashMap;

class Solution {
    static class Wrapper{
        Map<Integer,Integer> map;
        int length;
        
        public Wrapper(){
            this.map = new HashMap<>();
        }
        
        public void add(int idx){
            map.put(idx, map.getOrDefault(idx,0)+1);
        }
        public void remove(int idx){
            int nums = map.getOrDefault(idx,0);
            if(nums == 1) map.remove(idx);
            else map.put(idx, nums-1);
        }
        public int getSize(){
            return this.map.size();
        }
        
        @Override
        public String toString(){
            return this.map.toString();
        }
    }
    public int solution(int[] topping) {
        int answer = 0;
        if(topping.length < 2) return 0;
        if(topping.length == 2) return 1;
        
        Wrapper setLeft = new Wrapper();
        Wrapper setRight = new Wrapper();
        
        for(int i=0; i<topping.length; i++){
            if(i == 0) setLeft.add(topping[i]);
            else setRight.add(topping[i]);
        }
        

        for(int i=1; i<topping.length; i++){
                
            
            setLeft.add(topping[i]);
            setRight.remove(topping[i]);
            
            int leftSize = setLeft.getSize();
            int rightSize = setRight.getSize();

            
            if(leftSize == rightSize) answer++;
            
        }
        
        return answer;
    }
}