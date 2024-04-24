class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][][] his = new boolean[11][11][11][11];
        int x = 5;
        int y = 5;
        
        for(char next : dirs.toCharArray()){
            int nx = x;
            int ny = y;
            if(next=='D'){
                nx+=1;
                if(nx>10) continue;
            }else if(next == 'U'){
                nx-=1;
                if(nx < 0) continue;
            }else if(next =='L'){
                ny-=1;
                if(ny < 0) continue;
            }else{
                ny+=1;
                if(ny > 10) continue;
            }
            
            if((!his[x][y][nx][ny] && !his[nx][ny][x][y])) {
                    his[x][y][nx][ny] = true;
                    his[nx][ny][x][y] = true;
                    answer++;
                // System.out.println(x+" "+y+" to "+nx+" "+ny);
            } 
            
            x = nx;
            y = ny;
            
        }
        
        return answer;
    }
}