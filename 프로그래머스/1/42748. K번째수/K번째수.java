import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] command : commands){
            int[] next = sub(array, command[0]-1, command[1]-1);
            Arrays.sort(next);
            answer[idx++] = next[command[2]-1];
        }
        
        
        
        return answer;
    }
    
    int[] sub(int[] arr, int x, int y){
        int[] r = new int[y-x+1];
        for(int i=x; i<=y; i++){
            r[i-x] = arr[i];
        }
        return r;
    }
}