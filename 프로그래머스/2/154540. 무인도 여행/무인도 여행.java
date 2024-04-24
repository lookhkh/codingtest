import java.util.*;

class Solution {
    char[][] map;
    boolean[][] his;
    int[] ny = new int[]{-1,1,0,0};
    int[] nx = new int[]{0,0,-1,1};
    public int[] solution(String[] maps) {
        
        this.map = new char[maps.length][maps[0].length()];
        this.his = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            String next = maps[i];
            map[i] = next.toCharArray();
        }
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                if(his[i][j]) continue;
                if(map[i][j] =='X') continue;
                int result = bfs(i,j);
                list.add(result);
                System.out.println(result);
            }
        }
        
        if(list.isEmpty()) return new int[]{-1};
        
        return list.stream().sorted().mapToInt(Integer::new).toArray();
    }
    
    int bfs(int y, int x){
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{y,x});
        
        int sum = 0;
        while(!que.isEmpty()){
            
            int[] next = que.poll();
            if(his[next[0]][next[1]]) continue;
            his[next[0]][next[1]] = true;
            
            sum+= map[next[0]][next[1]]-'0';
            
            for(int i=0; i<4; i++){
                
                int ny = next[0]+this.ny[i];
                int nx = next[1]+this.nx[i];
                
                if(ny >= 0 && ny < map.length && nx >=0 && nx <map[0].length){
                    if(map[ny][nx] == 'X' || his[ny][nx] ) continue;
                    que.add(new int[]{ny,nx});
                }
                
            }
            
        }
        
        return sum;
        
    }
}