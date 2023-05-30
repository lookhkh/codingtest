/*
    첫 번째 칼럼은 기본기. 유니크 보장.
    
*/
import java.util.*;
class Solution {
    static class Tuple{
        
        int idx;
        int col;
        int pk;
        int[] arr;
        
        public Tuple(int idx, int pk, int col, int[] arr){
            this.idx = idx;
            this.pk = pk;
            this.arr = arr;
            this.col = arr[col];
        }
        
    }
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        List<Tuple> list = new ArrayList<>();
        
        int idx = 1;
        for(int[] w : data){
            Tuple t = new Tuple(idx++, w[0], col-1,w);
            list.add(t);
        }
        
        list.sort((t1,t2)->{
            if(t1.col!=t2.col) return Integer.compare(t1.col,t2.col);
            return Integer.compare(t2.pk,t1.pk);
        });
        
       
       for(int i=row_begin-1; i<row_end; i++){
           
           Tuple t = list.get(i);
           
           int[] arr = t.arr;
           
           int sum = 0;
           
           for(int j=0; j<arr.length; j++){
               sum += arr[j] % (i+1);
           }
           answer = answer ^ sum;
       }

        return answer;
    }
}