import java.util.*;
class Solution {
    
    Map<String, Integer> status;
    String[] ranking;
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        status = new HashMap<>();
        ranking = new String[players.length+1];
        
        for(int i=0; i<players.length; i++){
            status.put(players[i], i+1);
            ranking[i+1] = players[i];
        }
        
        for(String call :  callings){
            
            swap(call);
            
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = ranking[i+1];
        }
        
        return answer;
    }
    
    public void swap(String name){
        
        int currentRanking = status.get(name);
        String frontOne = ranking[currentRanking-1];
        
        ranking[currentRanking-1] = name;
        ranking[currentRanking] = frontOne;
        
        status.put(name, currentRanking-1);
        status.put(frontOne, currentRanking);
        
        
        
    }
}