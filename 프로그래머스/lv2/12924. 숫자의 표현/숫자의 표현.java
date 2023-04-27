class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1;
        int temp = 0;
        for(int i=1; i<=n; i++){
            
            temp += i;
            
            if(temp >= n){
                
                while(temp >= n){
                    
                    if(temp == n) answer++;
                    temp -= left;
                    left++;
                    
                }
                
            }
            
            
        }
        
        
        
        
        return answer;
    }
}