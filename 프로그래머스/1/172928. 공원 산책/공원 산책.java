import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] cur = new int[2];
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S') {
                    cur[0] = i;
                    cur[1] = j;
                    break;
                }
            }
        }
        
        
        for(String route : routes){
            
            String[] split = route.split(" ");
            String dir = split[0];
            int distance = Integer.parseInt(split[1]);
            
            moveIfCan(cur,park, dir, distance);
            
            
        }
    
        
        return cur;
    }
    
    private void moveIfCan(int[] cur, String[] park, String dir, int distance){

        if(dir.equals("N")){
            //북
            int currentX = cur[0];
            if(currentX - distance < 0) return;
            for(int i=currentX; i >= currentX - distance; i--){
                if(park[i].charAt(cur[1])=='X') return;
            }
            cur[0] = currentX - distance;
        }
        
        if(dir.equals("S")){
            int currentX = cur[0];
            if(currentX + distance >= park.length) return;
            for(int i=currentX; i <= currentX + distance; i++){
                if(park[i].charAt(cur[1])=='X') return;
            }
            cur[0] = currentX + distance;
        }
        
          if(dir.equals("W")){
            int curY = cur[1];
            if(curY-distance < 0) return;
            for(int i=curY; i >= curY - distance; i--){
                if(park[cur[0]].charAt(i)=='X') return;
            }
            cur[1] = curY - distance;
        }
        
        if(dir.equals("E")){
            int curY = cur[1];
            if(curY+distance >= park[0].length()) return;
            for(int i=curY; i <= curY + distance; i++){
                if(park[cur[0]].charAt(i)=='X') return;
            }
            cur[1] = curY + distance;
        }
    }
}