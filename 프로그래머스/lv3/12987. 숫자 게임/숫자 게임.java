import java.util.*;
import java.util.Arrays;

/*

*/

class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        
        Deque<Integer> que = new LinkedList<>();
        
        Arrays.sort(b);
        Arrays.sort(a);
        for(int w : b){
            que.add(w);
        }
        
        
       for(int i=a.length-1; i>=0; i--){
           
           int nextA = a[i];
           int first = que.peekFirst();
           int last = que.peekLast();
           
           if(last > nextA){
               que.pollLast();
               answer++;
           }else{
               que.pollFirst();
           }
           
       }
                
        return answer;
    }
}