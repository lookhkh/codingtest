class Solution {
    int cnt = 0;
    public boolean solution(int[][] key, int[][] lock) {
        int keySize = key.length;
        int lockSize = lock.length;
      
        int[][] extendLock = new int[lockSize + 2*( keySize-1)][lockSize + 2*(keySize-1)];
        
        for(int i=0; i<extendLock.length; i++){
            for(int j=0; j<extendLock[0].length; j++){
                extendLock[i][j] = 2;
                if(i >= keySize-1 && i <= keySize + lockSize-2 ){
                    if(j >= keySize-1 && j <= keySize + lockSize-2){
                        extendLock[i][j] = lock[i-(keySize-1)][j-(keySize-1)];
                    }
                }
            }
        }
        
        print(extendLock);
        
        for(int i=0; i<extendLock.length; i++){
            for(int j=0; j<extendLock[0].length; j++){
                if(extendLock[i][j] == 0) cnt++;
            }
        }
        
        for(int i=0; i<extendLock.length; i++){
            for(int j=0; j<extendLock[0].length; j++){
                for(int z = 0; z<4; z++){
                    boolean result = check(i,j,rotate(key,z), extendLock);
                    if(result) return true;
                }                
            }
        }

        return false;
    }
    
    public boolean check(int x, int y, int[][] key, int[][] lock){
        int tempCnt = 0 ;
        for(int i=x; i<lock.length; i++){
            for(int j=y; j<lock[0].length; j++){
                if(!(i-x >=0 && j-y>=0 && i-x<key.length && j-y < key[0].length)) continue;
                if(key[i-x][j-y] == 1 && lock[i][j] == 1) return false;
                if(key[i-x][j-y] == 1 && lock[i][j] == 0) tempCnt++;
            }
        }
        
        
        if(tempCnt == cnt) return true;
        return false;
        
    }
    
    public void print(int[][] r){
        for(int i=0; i<r.length; i++){
            String t ="";
            for(int j=0; j<r[0].length; j++){
                t+=r[i][j];
            }
            System.out.println(t);
        }
    }
    
    public int[][] rotate(int[][] original, int type){
        
        if(type== 0) return original;
        if(type == 1) return rotate(original);
        if(type == 2) return rotate(rotate(original));
        if(type == 3) return rotate(rotate(rotate(original)));
        int t = 1/0;
        return null;
    }
    
    public int[][] rotate(int[][] original){
        
        int[][] r = new int[original[0].length][original.length];
        
        for(int i=0; i<original.length; i++){
            for(int j=0; j<original[0].length; j++){
                r[j][original.length - i - 1] = original[i][j];
            }
        }
        
        return r;
        
    }
}