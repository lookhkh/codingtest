/*
    자연수 n에 대하여, n을 연속된 자연수의 합으로 표현하는 방법이 여러가지가 있을 수 있다.
    이때, 경우의 수를 구하시오.
    
    20
     2,3,4,5,6

*/
class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 1;
        int tempSum = 0;
        
        for(int right=1; right<=n; right++){
            
            tempSum+=right;
            if(tempSum >= n){
                
                while(tempSum>=n){
                    
                    if(tempSum == n) answer++;
                    tempSum -= left;
                    left++;
                    
                }
                
            }
            
        }
        
        return answer;
    }
}