import java.util.*;

class Solution {
    
        static class Node{
        
        String target;
        int idx;
        int cnt;
        
        public Node(String target,int idx ,int cnt){
            this.target = target;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean result = false;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)) result = true;
        }
        
        if(!result){
            return 0;
        }
        
        return bfs(begin, target, words);
        

    }
    
    public int bfs(String begin, String target, String[] words){
        
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(begin, -1, 0));
        
        boolean[] ch = new boolean[words.length];
        
        while(!que.isEmpty()){
            
            Node n = que.poll();
            
            if(n.idx != -1 && ch[n.idx]) continue;
            if(n.idx != -1) ch[n.idx] = true;
            
            if(n.target .equals(target)){
                return n.cnt;
            }
            
            for(int i=0; i<words.length; i++){
                
                if(ch[i]) continue;
                
                String word = words[i];
                
                if(!check(n.target, word)) continue;
                
                que.add(new Node(word,i,n.cnt+1));
                                    
                
            }
            
        }
        
        return 0;
    }
    public boolean check(String t, String t2){
        
        int cnt = 0;
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) != t2.charAt(i)) cnt++;
        }
        
        if(cnt == 1) return true;
        return false;
        
    }
}