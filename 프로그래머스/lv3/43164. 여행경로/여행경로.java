import java.util.*;
class Solution {
    List<String> result = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        dfs(tickets, "ICN", new boolean[tickets.length], "ICN");
        
        result.sort(null);
        
        return  result.get(0).split(" ");
    }
    
    public void dfs(String[][] tickets, String next, boolean[] ch, String visit){
        
        if(allPassPortUsed(ch)){
            result.add(visit);
        }
        
        for(int i=0; i<tickets.length; i++){
            
            if(ch[i]) continue;
            if(!tickets[i][0].equals(next)) continue;
            ch[i] = true;
            dfs(tickets, tickets[i][1],ch,visit+" "+tickets[i][1]);
            ch[i] = false;
        }
        
        
    }
    
    public boolean allPassPortUsed(boolean[] ch){
        for(int i=0; i<ch.length; i++){
            if(!ch[i]) return false;
        }
        return true;
    }
}