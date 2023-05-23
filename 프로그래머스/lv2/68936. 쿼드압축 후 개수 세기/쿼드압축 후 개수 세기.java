/*
    [1,1,0,0]
    [1,0,0,0]
    [1,0,0,1]
    [1,1,1,1]
    
*/
class Solution {
    int numOfZero = 0;
    int numOfOne = 0;
    int[][] arr;
    public int[] solution(int[][] arr1) {
        int[] answer = new int[2];
        
        arr = arr1;
        
        dividedAndConQuer(0,0,arr.length);
        
        answer[0] = numOfZero;
        answer[1] = numOfOne;
        return answer;
    }
    
    public void dividedAndConQuer(int x, int y, int n){
        
        boolean isValid = true;
        
        int prev = -1;
        
        for(int i=x; i<x+n && isValid; i++){
            for(int j=y; j<y+n; j++){
                
                    if(prev == -1) prev = arr[i][j];
                    else if(prev != arr[i][j]) {
                        isValid = false;
                        break;
                    }
                
            }
        }
        
        if(isValid){
            if(prev == 1) numOfOne+=1;
            else if(prev == 0) numOfZero += 1;
        }else{
            
            n = n / 2;
            
            dividedAndConQuer(x,y,n);
            dividedAndConQuer(x,y+n,n);
            dividedAndConQuer(x+n,y,n);
            dividedAndConQuer(x+n,y+n,n);

            
            
            
        }
        
        
    }
}