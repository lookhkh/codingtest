class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] temp = new int[board.length+1][board[0].length+1];
        
        for(int[] next : skill){
            
            boolean isAttack = next[0] == 1;
            int degree = next[5];
            
            int[] leftTop = new int[]{next[1], next[2]};
            int[] leftBottom = new int[]{next[3]+1, next[2]};
            int[] rightTop = new int[]{next[1], next[4]+1};
            int[] rightBottom = new int[]{next[3]+1, next[4]+1};
            
            temp[leftTop[0]][leftTop[1]] += !isAttack? degree : -1 * degree; 
            temp[leftBottom[0]][leftBottom[1]] += isAttack? degree : -1 * degree; 
            temp[rightTop[0]][rightTop[1]] += isAttack? degree : -1 * degree; 
            temp[rightBottom[0]][rightBottom[1]] += !isAttack? degree : -1 * degree; 

        }
        
     
        
        for(int i=0; i<temp[0].length; i++){
            for(int j=1; j<temp.length; j++){
                temp[j][i] += temp[j-1][i];
            }
        }
        
        for(int i=0; i<temp.length; i++){
            for(int j=1; j<temp[0].length; j++){
                temp[i][j]+=temp[i][j-1];
            }
        }
        
        int answer = 0;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                board[i][j] += temp[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        

        
        return answer;
    }
}