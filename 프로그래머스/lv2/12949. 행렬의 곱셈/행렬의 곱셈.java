/*
    행렬의 곱셈
    
    (1,2) * (2,3
             1,4)

*/
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i=0; i<arr1.length; i++){
            
            int[] row = arr1[i];
            
            for(int j=0; j<arr2[0].length; j++){
                
                int temp =0;
                
                for(int z=0; z<row.length; z++){
                    temp+=row[z] * arr2[z][j];
                }
                
                answer[i][j] = temp;
                
            }
            
        }
            
        
        
        return answer;
    }
}