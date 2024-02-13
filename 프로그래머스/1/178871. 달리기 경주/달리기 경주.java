import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String,Integer> table = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            String player = players[i];
            table.put(player, i);
        }
        
        for(String calling : callings){
            
            int curIdx = table.get(calling);
            int frontIdx = curIdx-1;
            String frontName = players[frontIdx];
                        
            swap(curIdx, frontIdx, players);
            table.put(frontName, table.get(frontName)+1);
            table.put(calling, table.get(calling)-1);
        }
        
        
        
        return players;
    }
    private void swap(int a, int b, String[] arr){

        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        
    }
}