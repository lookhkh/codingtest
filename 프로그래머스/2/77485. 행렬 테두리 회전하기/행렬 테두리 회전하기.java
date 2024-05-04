class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = create(rows, columns);
        int idx = 0;
        for(int[] query : queries){
            int min = move(arr, query);
            answer[idx++] = min;
        }

        return answer;
    }
    
    int move(int[][] arr, int[] query){
        
        int x = query[0]-1;
        int y = query[1]-1;
        int nx = query[2]-1;
        int ny = query[3]-1;
        
        int[][] temp = clone(arr);
        int min = Integer.MAX_VALUE;
        
        for(int i=y; i<ny; i++){
            arr[x][i+1] = temp[x][i];
            min = Math.min(min, arr[x][i+1]);
        }
        
        for(int i=x; i<nx; i++){
            arr[i+1][ny] = temp[i][ny];
            min = Math.min(min, arr[i+1][ny]);
        }
        
        for(int i=ny; i>y; i--){
            arr[nx][i-1] = temp[nx][i];
            min = Math.min(min, arr[nx][i-1]);
        }
        
        for(int i=nx; i>x; i--){
            arr[i-1][y] = temp[i][y];
            min = Math.min(min, arr[i-1][y]);
        }   
        
        return min;
    }
    
    int[][] clone(int[][] arr){
        int[][] clone = new int[arr.length][arr[0].length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                clone[i][j] = arr[i][j];
            }
        }
        return clone;
    }
     
    int[][] create(int rows, int columns){
        int cur = 1;
        int[][] arr = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = cur++; 
            }
        }
        return arr;
    }
    
    void log(int[][] arr){
         for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
                System.out.println("");
        }
    }
}