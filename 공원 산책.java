//https://school.programmers.co.kr/learn/courses/30/lessons/172928#
class Solution {

    int[] start;
    public int[] solution(String[] park, String[] routes) {

        char[][] map = new char[park.length][park[0].length()];
        
        for(int i=0; i<park.length; i++){
            String next = park[i];
            
            for(int j=0; j<next.length(); j++){
                
                map[i][j] = next.charAt(j);
                if(map[i][j] == 'S'){
                    start = new int[]{i,j};    
                }            
            }
        }
        
            for(String route : routes){
                
                char direction = route.charAt(0);
                int cnt = route.charAt(2)-'0';
                
                System.out.println("시작점 "+direction+"  "+cnt);
                
                if(direction == 'N'){
                    
                    int startX = start[0];
                    
                    if(start[0]-cnt < 0) continue;
                    
                    boolean result = true;
                    for(int x = startX-1; x>=startX-cnt; x--){
                        if(map[x][start[1]]=='X'){
                            result = false;
                            break;
                        }
                    }
                    
                    if(result) start[0] -= cnt;
                }
                
                if(direction == 'S'){
                    
                   int startX = start[0];
                    
                    if(start[0]+cnt >= map.length) continue;
                    
                    boolean result = true;
                    for(int x = startX+1; x<=startX+cnt; x++){
                        System.out.println("S1 "+map[x][start[0]]);
                        if(map[x][start[1]]=='X') {
                            result = false;     
                            break;
                        }
                    }
                    System.out.println(direction+"  "+cnt+"  "+result);
                    if(result) start[0] += cnt; 
                }
                
                if(direction == 'W'){
                    
                    int nextY = start[1];
                    
                    if(nextY-cnt < 0) continue;
                    boolean result = true;
                    
                    for(int i=nextY; i>=nextY-cnt; i--){
                        if(map[start[0]][i]=='X') {
                            result = false;
                            break;
                        }
                    }
                    
                    System.out.println(direction+"  "+cnt+"  "+result);                    
                    if(result) start[1] -= cnt;
                    
                }
                
                if(direction == 'E') {
                    int nextY = start[1];
                    
                    if(nextY+cnt >= map[0].length) continue;
                    boolean result = true;
                    
                    for(int i=nextY; i<=nextY+cnt; i++){
                        if(map[start[0]][i]=='X') {
                            result = false;
                            break;
                        }
                    }
                    
                    if(result) start[1] += cnt;
                    
                }
                
                
            }
            
            System.out.println("정답: "+start[0]+" "+start[1]);
        
        return start;
    }
}
