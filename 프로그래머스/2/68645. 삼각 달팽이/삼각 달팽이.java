import java.util.*;
class Solution {
    int cur = 1;
    public List<Integer> solution(int n) {
        int[] answer = {};
        int[][] history = new int[n][n];

        recursive(history, 0,0);
        
        List<Integer> ans = new ArrayList<>();
        
        for(int[] next : history){
            for(int nn : next){
                if(nn !=0) ans.add(nn);
            }
        }
                
        
        return ans;
    }
    
    void recursive(int[][] history, int x, int y){
        if(x >=history.length) return;
        if(history[x][y] !=0) return;
        int[] nextAfterDown = moveDown(history, x, y);
        int[] nextAfterRight = moveRight(history, nextAfterDown[0],nextAfterDown[1]+1);
        int[] nextAfterLeftUp = moveLeftUp(history, nextAfterRight[0], nextAfterRight[1]);

        recursive(history, nextAfterLeftUp[0]+1, nextAfterLeftUp[1]);

    }
    
    int[] moveDown(int[][] history, int x, int y){
        int[] result = new int[2];
        for(int i=x; i<history.length; i++){
            if( history[i][y] ==0 ){
                history[i][y] = cur++;
                result[0] = i;
                result[1] = y;
            }else{
                break;
            }
        }
        return result;
        
    }
    
    int[] moveRight(int[][] history, int x, int y){
        int[] result = new int[2];
        for(int i=y; i<history[x].length; i++){
            if(history[x][i] == 0){
                history[x][i] = cur++;
                result[0] = x;
                result[1] = i;
            }else{
                break;
            };
        }
     
        return result;
        
    }
    
    int[] moveLeftUp(int[][] history, int x, int y){
        int[] result = new int[2];
        while(true){
            
            x = x-1;
            y = y-1;
            if(x < 0 || y < 0) break;
            if(history[x][y] ==0){
                result[0] = x;
                result[1] = y;
                history[x][y] = cur++;
            }else{
                break;
            }
                
            
        }
     
        return result;
        
    }
    
    void print(int[][] history){
        for(int i=0; i<history.length; i++){
            for(int j=0; j<history[i].length; j++){
                System.out.print(" "+history[i][j]+" ");
            }
                System.out.println("");
        }
    }
}