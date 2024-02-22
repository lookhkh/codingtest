import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int next : moves){
            
            int move = next - 1;
            
            int one = find(board, move);
            if(one > 0){
                if(!stack.isEmpty() && stack.peek() == one) {
                    stack.pop();
                    answer++;
                }else{
                    stack.push(one);
                }
            }
        }

        return answer * 2;
    }
    
    int find(int[][] board, int col){
        
        for(int i=0; i<board.length; i++){
            int next = board[i][col];
            if(next > 0) {
                board[i][col] = 0;
                return next;
            }
        }
        
        return -1;
        
    }
}