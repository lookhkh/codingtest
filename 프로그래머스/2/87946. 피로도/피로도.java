class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        dfs(k, dungeons);
        
        return cnt;
    }
    
    int cnt = 0;
    
    void dfs(int k, int[][] dungeon){
        boolean[] path = new boolean[dungeon.length];
        dfs(k, dungeon, path, 0);
    }
    void dfs(int k, int[][] d, boolean[] path, int cnt){
        
        for(int i=0; i<d.length; i++){
            if(path[i]) continue;
            int req = d[i][0];
            if(k < req) continue;
            path[i] = true;
            dfs(k- d[i][1], d, path, cnt+1);
            path[i] = false;
        }
        
        
        this.cnt = Integer.max(this.cnt, cnt);
        
        
        
    }
}