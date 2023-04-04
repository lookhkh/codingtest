//https://school.programmers.co.kr/learn/courses/30/lessons/147354

import java.util.Arrays;
import java.util.Stack;

class Solution {
    static class Tuple implements Comparable<Tuple>{
        
        int sortKey;
        int[] data;
        
        public Tuple(int[] data, int sortKey){
            this.sortKey = sortKey;
            this.data = data;
        }
        
        @Override
        public int compareTo(Tuple t1){
            int sortKey = this.data[this.sortKey];
            int sortKeyForT1 = t1.data[this.sortKey];
            
            if( sortKey != sortKeyForT1 ) return sortKey - sortKeyForT1;
            return t1.data[0] - this.data[0];
            
        }
        
        public int hash(int idx){
            int t = 0;
            
            for(int w : data){
                t+= w % idx;
            }
            
            return t;
            
        }
        
        @Override
        public String toString(){
            String t = "";
            for(int tw : data){
                t+=" "+tw;
            }
            
            return t;
        }
        
    }
    
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Tuple[] tuples = new Tuple[data.length];
        
        for(int i=0; i<data.length; i++){
            int[] d = data[i];
            Tuple t = new Tuple(d, col-1);
            tuples[i] = t;
        }
        
        Arrays.sort(tuples);

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<tuples.length; i++){
            
            if(i >= row_begin-1 && i<= row_end-1){
                
                Tuple t = tuples[i];
                int idx = i+1;
                
                int sn = t.hash(idx);
                stack.push(sn);
                
                
            }
            
        }
        
        
        int previous = Integer.MIN_VALUE;
        while(!stack.isEmpty() ){
            
            
            if(previous == Integer.MIN_VALUE) previous = stack.pop();
            else{
                
                previous = previous ^ stack.pop();
                

                
            }
        }
        
        

        return previous;
    }
}