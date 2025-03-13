class Solution {
    public int[][] solution(int n) {
        
        if(n == 1) return new int[][]{{1}};
        
        int[][] answer = new int[n][n];
        
        int cnt = 1;
        
        for(int itr =0; itr < n/2; itr++){
            
            int startX = itr;
            int startY = itr;
                        
            for(; startY < (n-1)-itr; startY++){
                answer[startX][startY] = cnt++;
            }
            
            for(; startX < (n-1)-itr; startX++){
                answer[startX][startY] = cnt++;
            }
            
            for(; startY >itr; startY--){
                answer[startX][startY] = cnt++;
            }
            
            for(; startX > itr; startX--){
                answer[startX][startY] = cnt++;
            }
        }
        
        if(n%2 != 0){
            answer[n/2][n/2] = cnt;
        }
        
        
        return answer;
    }
}