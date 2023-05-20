/*
    n개의 음이 아닌 정수.
    순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 구한다.

*/
class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(target, 0, 0, numbers);
        
        return cnt;
    }
    
    public void dfs(int target, int cur, int idx ,int[] nums){
        
        if(idx == nums.length){
            if(target == cur) cnt++;
        }else{
            
            dfs(target, cur+nums[idx],idx+1,nums);
            dfs(target, cur-nums[idx],idx+1,nums);
            
            
        }
        
    }
}