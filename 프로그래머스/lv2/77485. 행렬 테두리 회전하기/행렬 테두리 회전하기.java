import java.util.*;

class Solution {
    
    int[][] metrix;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        metrix = new int[rows][columns];
        
        int cnt = 1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                metrix[i][j] = cnt++;
            }
        }
        
        int idx = 0;
        
        for(int[] query : queries){
            
            int startX = query[0]-1;
            int startY = query[1]-1;
            int endX = query[2]-1;
            int endY = query[3]-1;
            
            int[][] copy = copy(query);
            int min = Integer.MAX_VALUE;
            //상 왼 -> 오
            
            for(int i=endY; i>startY; i--){
                metrix[startX][i] = copy[startX][i-1]; 
                min = Math.min(min,metrix[startX][i]);
            }
            
            //오 위 -> 아래
            for(int i= endX; i>startX; i--){
                metrix[i][endY] = copy[i-1][endY];
                min = Math.min(min,metrix[i][endY]);

            }
            
            //아래 오 -> 왼
            for(int i=startY; i<endY; i++){
                metrix[endX][i] = copy[endX][i+1];
                min = Math.min(min,metrix[endX][i]);

            }
            
            //왼 아래->위
            for(int i=startX; i<endX; i++){
                metrix[i][startY] = copy[i+1][startY];
                min = Math.min(min,metrix[i][startY]);

            }
            
            answer[idx++] = min;
            
        }
        
            
        return answer;
    }
    
    public void print(int[][] m){
         
        for(int i=0; i<m.length; i++){
            String t = "";
            for(int j=0; j<m[0].length; j++){
                t+=m[i][j]+" ";
            }
            System.out.println(t);
        }
    }
    
    public int[][] copy(int[] query){
         
        
        int[][] copy = new int[metrix.length][metrix[0].length];
        
        for(int i=0; i<metrix.length; i++){
            for(int j=0; j<metrix[0].length; j++){
                copy[i][j] = metrix[i][j];
            }
        }
        
        return copy;
        
    }
}