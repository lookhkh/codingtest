class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        int idx = 0;
        int cur = 0;
        dfs(idx, numbers, cur, target);
        return cnt;
    }
    
    void dfs(int idx, int[] numbers, int cur, int target){
        if(idx == numbers.length){
            if(cur == target) cnt++;
        }else{
            
            dfs(idx+1, numbers, cur+numbers[idx], target);
            dfs(idx+1, numbers, cur-numbers[idx], target);
                
                
        
            
        }
    }
}