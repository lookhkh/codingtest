/*
    시뮬레이션 문제.
    좌표평면. 0,0부터 시작.
*/
class Solution {
    int[][][][] map;
    
    //상하좌우
    int[] dirX = new int[]{-1,1,0,0};
    int[] dirY = new int[]{0,0,-1,1};
    
    public int solution(String dirs) {
        map = new int[11][11][11][11];
        int answer = 0;
        
        int[] curPos = new int[]{5,5};
        for(int i=0; i<dirs.length(); i++){
            int nextPos = getDirection(dirs.charAt(i));
            
            int nextX = curPos[0]+dirX[nextPos];
            int nextY = curPos[1]+dirY[nextPos];
            
            if(!(nextX >=0 && nextY >=0 && nextX <= 10 && nextY <= 10)) continue; 
            
            if(map[curPos[0]][curPos[1]][nextX][nextY] == 0 && map[nextX][nextY][curPos[0]][curPos[1]] == 0){
                    answer++;
                    map[curPos[0]][curPos[1]][nextX][nextY] = 1;
                    map[nextX][nextY][curPos[0]][curPos[1]] = 1;
            }          
            
            curPos[0] = nextX;
            curPos[1] = nextY;
            
         
            
        }
        
        
        return answer;
    }
    
    public int getDirection(char cmd){
        if(cmd == 'U') return 0;
        if(cmd == 'D') return 1;
        if(cmd == 'L') return 2;
        return 3;
    }
}