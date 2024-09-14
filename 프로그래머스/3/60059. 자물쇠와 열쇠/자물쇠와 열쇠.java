import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        
        int locksNum = 0;
        
        for(int i=0; i<lock.length; i++){
            for(int j=0; j<lock[i].length; j++){
                if(lock[i][j] == 0) locksNum++;
            }
        }
        
        int extendedLength = lock.length+ 2 * (key.length-1);
        int[][] extendedMap = new int[extendedLength][extendedLength];
        
        for(int i=0; i<extendedMap.length; i++){
            for(int j=0; j<extendedMap.length; j++){
                extendedMap[i][j] = 2;
            }
        }
        
        
        int offsetForLock = key.length-1;

        for(int i=offsetForLock; i<offsetForLock+lock.length; i++){
            for(int j=offsetForLock; j<offsetForLock+lock.length; j++){
                
                extendedMap[i][j] = lock[i-offsetForLock][j-offsetForLock];
                
            }
        }
        
        System.out.println(offsetForLock);
        log(extendedMap);
            
        
        for(int c=0; c<4; c++){
            
            for(int i=0; i<extendedLength - offsetForLock; i++){
                for(int j=0; j<extendedLength - offsetForLock; j++){
                                
                    int cnt = 0;
                    boolean shouldStop = false;
                    
                
                    
                    for(int x=0; x<key.length && !shouldStop; x++){
                        for(int y=0; y<key.length && !shouldStop; y++){
                            
                            if(extendedMap[i+x][j+y] == -1 ){
                                continue;
                            };
                            if(key[x][y] == 1 && extendedMap[i+x][j+y] == 1){
                                shouldStop = true;
                                continue;
                            }
                            if(key[x][y] == 1 && extendedMap[i+x][j+y] == 0){
                                cnt++;
                            }
                        }
                    }
 
                    if(!shouldStop && locksNum == cnt) return true;
                }
            }
            
            key = rotate(key);
        
        }
        
        
        return false;
    }
    
    void log(int[][] key){
          for(int i=0; i<key.length; i++){
                for(int j=0; j<key.length; j++){
                    System.out.print(key[i][j]);
                }
                System.out.println(" ");
            }
    }

    int[][] rotate(int[][] lock){
        int n = lock.length;
        int m = lock[0].length;
        int[][] rotate = new int[m][n];

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = lock[n-1-j][i];
            }
        }
        
        return rotate;
        
    }
}