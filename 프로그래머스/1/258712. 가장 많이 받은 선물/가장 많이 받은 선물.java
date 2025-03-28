import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> index = new HashMap<>();
        Map<Integer, String> reverseIndex = new HashMap<>();

        int z=0;
        for(String next : friends){
            index.put(next, z++);
            reverseIndex.put(index.get(next), next);
        }

        
        int[][] tabel = new int[friends.length][friends.length];
        Map<String, Integer> presentIndex = new HashMap<>();

        for(String his : gifts){
            String[] arr = his.split(" ");
            String giver = arr[0];
            String taker = arr[1];
            
            tabel[index.get(giver)][index.get(taker)]++;
            presentIndex.put(giver, presentIndex.getOrDefault(giver,0)+1);
            presentIndex.put(taker, presentIndex.getOrDefault(taker,0)-1);
            
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<tabel.length; i++){
            
            int[] history = tabel[i];
            int cnt = 0;
            for(int j=0; j<history.length; j++){
                if(i == j) continue;
                
                int giverCnt = history[j];
                int receiverCnt = tabel[j][i];

                if(giverCnt > receiverCnt) {
                    cnt++;
                }else if(giverCnt == receiverCnt){
                    
                    int zisuForA = presentIndex.getOrDefault(reverseIndex.get(i),0);
                    int zisuForB = presentIndex.getOrDefault(reverseIndex.get(j),0);
                    if(zisuForA > zisuForB) cnt++;
                    
                }
                
            }
            max = Math.max(max, cnt);
            
        }
        
        return max;
    }
}