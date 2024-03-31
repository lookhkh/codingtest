
class Solution {
    int min = Integer.MAX_VALUE;
    public int solution(int storey) {
        return dfs(0, storey);
    }
    
    int dfs(int cnt, int cur){
        if(cur < 0) return Integer.MAX_VALUE;
        if(cur == 0 ) return cnt;
        if(isRight(cur)){
           return cnt+1;   
        }else{
            
            int last = cur % 10;
            min = Math.min(dfs(cnt+last, cur / 10 ), min);
            min = Math.min(dfs(cnt+(10-last), (cur / 10)+1), min);
            return min;            
        }
    }
    
    boolean isRight(int num){
        
        while(num > 1){
            if(num % 10 !=0) return false;
            num = num/10;
        }
        return true;
    }
    
}
