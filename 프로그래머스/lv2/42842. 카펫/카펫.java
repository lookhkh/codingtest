class Solution {
    public int[] solution(int brown, int yellow) {
        
        int half = brown / 2;
        for(int x=1; x<half; x++){
            for(int y=1; y<=x; y++){
                if(x+y == half && x>=y+2){
                    
                    int tempX = x-2;
                    int tempY = y;
                    
                    if(tempX <= 0) continue;

                    if(tempX * tempY == yellow){
                        
                        return new int[]{x,y+2};
                    }
                    
                }
            }
        } 
        
        
        return new int[2];
    }
}