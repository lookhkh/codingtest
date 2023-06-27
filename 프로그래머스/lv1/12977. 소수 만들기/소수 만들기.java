class Solution {
    
    int answer = 0;

    public int solution(int[] nums) {
        
        combination(0,0,0,nums);        

        return answer;
    }
    
    public void combination(int cur, int idx, int sum, int[] nums){
        
        if(cur == 3){
            for(int i=2; i<=Math.sqrt(sum); i++){
                if( sum % i ==0) return;
            }
            
            answer++;
            
        }else{
            
            for(int i=idx; i<nums.length; i++){
                combination(cur+1,i+1, sum+nums[i],nums);
            }
            
        }
        
    }
}