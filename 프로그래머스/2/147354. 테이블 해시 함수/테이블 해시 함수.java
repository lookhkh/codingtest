/**
모든 칼럼의 값은 정수타입
첫 번째 칼럼은, 키로서 중복이 발생하지 않음.


**/
import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (t1,t2)->{
            int key = 0;
            int idx = col-1;
            int corForT1 = t1[idx];
            int corForT2 = t2[idx];
            
            if(corForT1 == corForT2) return Integer.compare(t2[key], t1[key]);
            return Integer.compare(corForT1, corForT2);
            
        });
        
        int sum = 0;
        for(int i=row_begin; i<=row_end; i++){
            int[] next = data[i-1];
            int length = i;
            int tempSum = 0;
            for(int j=0; j<next.length; j++ ){
                tempSum+=(next[j] % length);
            }

            sum = sum ^ tempSum;
        }
                
        
        return sum;
    }
}