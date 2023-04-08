//https://school.programmers.co.kr/learn/courses/30/lessons/142085#

import java.util.Arrays;
import java.util.Stack;

class Solution {
    static class Tuple implements Comparable<Tuple>{
        
        int sortKey;
        int[] data;
        
        public Tuple(int[] data, int sortKey){
            this.sortKey = sortKey;
            this.data = data;import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
  
    public int solution(int n, int k, int[] enemy) {
    
        if(k >= enemy.length) return enemy.length;
        PriorityQueue<Integer> que = new PriorityQueue(Comparator.reverseOrder());
        
        int i=0;
        for(; i<enemy.length; i++){
            
            int next = enemy[i];
            que.add(next);

            if(n >= next) n-=next;
            else{
                
                while(k>0 && !que.isEmpty() && n<next){
                    n+=que.poll();
                    k--;
                }
                
                if(n >= next) n-=next;
                else break;
                
            }
            
            
        }
        
        return i;
    
    }
}