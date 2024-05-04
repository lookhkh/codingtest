class Solution
{
    public int solution(int [][]arr)
    {
        int answer = 1;
        boolean isOneZero = true;
        int[][] b = new int[arr.length][arr[0].length];
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b[0].length; j++){
                b[i][j] = arr[i][j];
                if(b[i][j] == 1) isOneZero = false;
            }
        }
        
        if(isOneZero) return 0;
        
        
        for(int i = 1; i<b.length; i++){
            for(int j=1; j<b[0].length; j++){
                if(arr[i][j] == 0) continue;
                if(arr[i][j] == arr[i-1][j] && arr[i][j] == arr[i][j-1] && arr[i][j] == arr[i-1][j-1]){
                    b[i][j] = Math.min(Math.min(b[i-1][j-1], b[i-1][j]), b[i][j-1])+1;
                    answer = Math.max(answer, b[i][j] * b[i][j]);
                }
            }
        }

        return answer;
    }
}