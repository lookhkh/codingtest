import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        List<String> wordss = Arrays.asList(words);
        if(!begin.equals(target) && !wordss.contains(target)) return 0;
        return bfs(wordss, begin, target);
        
    }
    
    int bfs(List<String> words, String begin, String target){
        PriorityQueue<Value> que = new PriorityQueue<>((t1,t2)->Integer.compare(t1.cnt, t2.cnt));
        boolean[] path = new boolean[words.size()];
        que.add(new Value(begin, 0));
        
        while(!que.isEmpty()){
            
            Value next = que.poll();
            if(next.same(target)) return next.cnt;
            
            for(int i=0; i<words.size(); i++){
                if(path[i]) continue;
                String n = words.get(i);
                if(next.isChangeable(n)){
                    path[i] = true;
                    que.add(new Value(n, next.cnt+1));
                }
            }
            
            
        }
        
        return 1;
    }
}

class Value{
    String value;
    int cnt;
    Value(String value, int cnt){
        this.value = value;
        this.cnt = cnt;
    }
    boolean isChangeable(String next){
        int failCnt = 0;
        for(int i=0; i<next.length(); i++){
            char thisChar = this.value.charAt(i);
            char nextChar = next.charAt(i);
            if(thisChar != nextChar){
                if(failCnt >= 1) return false;
                failCnt+=1;
            }
        }
        
        return true;
    }
    
    boolean same(String target){
        return this.value.equals(target);
    }
}