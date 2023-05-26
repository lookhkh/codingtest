/*
    X 또는 1~9 사이의 자연수
    
*/
import java.util.*;
class Solution {
    char[][] map;
    
    int[] dirX = new int[]{-1,1,0,0};
    int[] dirY = new int[]{0,0,-1,1};
    
    public int[] solution(String[] maps) {
        
        map = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        boolean[][] ch = new boolean[map.length][map[0].length];
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(ch[i][j]) continue;
                if(map[i][j] == 'X') continue;
                ch[i][j] = true;
                int result = bfs(i,j,ch);
                answer.add(result);
            }
        }
        
        if(answer.isEmpty()) return new int[]{-1};
        
        return answer.stream()
                     .sorted()
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
    
    public int bfs(int x, int y, boolean[][] ch){
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{x,y});
        
        int answer = 0;
        
        while(!que.isEmpty()){
            
            int[] n = que.poll();
            
            answer += map[n[0]][n[1]]-'0';
            
            for(int i=0; i<4; i++){
                int nextX = n[0]+dirX[i];
                int nextY = n[1]+dirY[i];
                
                if(nextX>=0 && nextY>=0 && nextX<map.length && nextY<map[0].length){
                    
                    if(ch[nextX][nextY]) continue;
                    if(map[nextX][nextY] == 'X') continue;
                    
                    ch[nextX][nextY] = true;
                    que.add(new int[]{nextX,nextY});
                    
                }
            }
            
            
            
        }
        
        
        return answer;
    }
}