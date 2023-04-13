//https://school.programmers.co.kr/learn/courses/30/lessons/68936

class Solution {
    
    int zero = 0;
    int one = 0;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        divideAndConquer(arr,0,0,arr.length);
        
        
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
    
    public void divideAndConquer(int[][] original, int startX, int startY, int size){
        
        boolean result = true;
        int previous = -1;

        for(int i=startX; result&&i<startX+size; i++){
            for(int j=startY; result&&j<startY+size; j++){
                
                int current = original[i][j];
                if(previous == -1) previous = current;
                else{
                    
                    if(current != previous){
                        result = false;
                    }
                    
                }
                
            }
        }
        
        if(result){
            if(previous == 0) this.zero++;
            else this.one++;
            return;
        }else{
            
            int nextSize = size/2;
            divideAndConquer(original, startX,startY, nextSize);
            divideAndConquer(original, startX,startY+nextSize, nextSize);
            divideAndConquer(original, startX+nextSize,startY, nextSize);
            divideAndConquer(original, startX+nextSize,startY+nextSize, nextSize);

            
            
        }
        
        
    }
}