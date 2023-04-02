//https://school.programmers.co.kr/learn/courses/30/lessons/77485

class Solution {
	
	
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] answer = new int[rows][columns];
        int nextNum = 1;
        
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<answer[i].length; j++){
                
                answer[i][j] = nextNum++;
                
            }
        }
        
        int[] result = new int[queries.length];
        int cnt = 0;
        
        for(int[] query : queries){
            
            int min = Integer.MAX_VALUE;
            
            int startX = query[0] -1;
            int startY = query[1] -1;
            int endX = query[2] - 1;
            int endY = query[3] -1;
           
            
            int[][] copy = new int[answer.length][answer[0].length];
            for(int i=startX; i<=endX; i++){
                for(int j=startY; j<=endY; j++){
                    copy[i][j] = answer[i][j];
                }
            }
            
                        
           //위
            
            for(int i=endY; i>startY; i--) {
            	answer[startX][i] = copy[startX][i-1];
            	min = Math.min(min, answer[startX][i]);
            }

            
            for(int i=endX; i>startX; i--) {
            	answer[i][endY] = copy[i-1][endY];
            	min = Math.min(min, answer[i][endY]);
            }
            

            for(int i=startY; i<endY; i++) {
            	answer[endX][i] = copy[endX][i+1];
            	min = Math.min(min, answer[endX][i]);

            }
            
            

            for(int i=startX; i<endX; i++) {
            	answer[i][startY] = copy[i+1][startY];
            	min = Math.min(min, answer[i][startY]);

            }
            
            
            result[cnt++] = min;
            
        }
        
        
        return result;
    }
}