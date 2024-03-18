import java.util.*;
class Solution {
    Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, 0,user_id, banned_id, new boolean[user_id.length]);
        return set.size();
    }
    
    void dfs(int idx, int cur, String[] user_id, String[] banned_id, boolean[] path){
        if(cur == banned_id.length){
            
            List<String> list = new ArrayList<>();
            
            for(int i=0; i<path.length; i++){
                if(path[i]){
                    list.add(user_id[i]);
                }
            }
            set.add(list.toString());
            
        }else{
            
            for(int i=idx; i<banned_id.length; i++){
                for(int j=0; j<user_id.length; j++){
                    
                    if(path[j]) continue;
                    if(!new Tuple(user_id[j], banned_id[i]).check()) continue;
                    path[j] = true;
                    dfs(i+1, cur+1, user_id, banned_id, path);
                    path[j] = false;
                    
                }
            }
            
        }
        
        
    }
}

class Tuple{
    String userId;
    String banId;
    public Tuple(String user, String ban){
        this.userId = user;
        this.banId = ban;
    }
    
    public boolean check(){
        
        if(userId.length() != banId.length()) return false;
        for(int i=0; i<userId.length(); i++){
            char u = userId.charAt(i);
            char b = banId.charAt(i);
            if(b == '*') continue;
            if(u != b) return false;
        }
        return true;
        
    }
  
}