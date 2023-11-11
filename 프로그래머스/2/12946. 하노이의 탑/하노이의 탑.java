import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    List<List<Integer>> arr = new ArrayList<>();
    public List<List<Integer>> solution(int n) {
        int[][] answer = {};
        
        hanoi(n, 1,3,2);
                
        
        return arr;
    }
    
    public void hanoi(int row, int source, int destionation, int temp){
        if(row >0){
             
            hanoi(row-1, source, temp, destionation);
            arr.add(Arrays.asList(source, destionation));
            hanoi(row-1, temp, destionation, source);

        }
    }
}