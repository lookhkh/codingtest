/*
    탐험을 시작하기 위해 필요한 '최소 필요 필요도'
    탐험을 마쳤을 때 소모되는 '소모 피로도'

    하루 한 번 돌 수 있는 던전과 최소 필요 필요도, 소모 필요도가 주어졌을 때,
    최대한 많은 던전 수는?
    
*/
class Solution {
    int cntMax = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        dfs(k,0,dungeons, new boolean[dungeons.length]);
        
        return cntMax;
    }
    
    public void dfs(int k, int cnt,int[][] dungeons, boolean[] ch ){
        
        if(k < 0) return;
        if(k >= 0){
            
            cntMax = Math.max(cntMax,cnt);
            
            for(int i=0; i<dungeons.length; i++){
                
                if(ch[i]) continue;
                
                int[] dungeon = dungeons[i];
                
                if(k < dungeon[0]) continue;
                
                ch[i] = true;

                dfs(k-dungeon[1],cnt+1,dungeons,ch);
                
                ch[i] = false;
                
                //dfs(k,cnt,dungeons,ch);

            }
            
        }
        
    }
}