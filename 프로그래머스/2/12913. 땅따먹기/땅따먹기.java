class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int[][] r = new int[land.length][land[0].length];
        for(int i=0; i<4; i++) r[0][i] = land[0][i];
        
        for(int i=1; i<land.length; i++){
            r[i][0] = land[i][0]+max(max(r[i-1][1], r[i-1][2]), r[i-1][3]); 
            r[i][1] = land[i][1]+max(max(r[i-1][0], r[i-1][2]), r[i-1][3]); 
            r[i][2] = land[i][2]+max(max(r[i-1][0], r[i-1][1]), r[i-1][3]); 
            r[i][3] = land[i][3]+max(max(r[i-1][0], r[i-1][1]), r[i-1][2]); 
        }
        
        
        return max(max(max(r[land.length-1][0],r[land.length-1][1]),r[land.length-1][2]),r[land.length-1][3]);
    }
    int max(int x, int y){
        return Integer.max(x,y);
    }
}