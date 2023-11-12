class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            if(getYaksuIsEvenNumber(i)) answer+=i;
             else answer-=i;  
        }
        
        return answer;
    }
    
    public boolean getYaksuIsEvenNumber(int num){
        
        int cnt = 0;
        for(int i=1; i*i<=num; i++){
            if(i * i == num) cnt++;
            if(num % i == 0){
                cnt+=2;
            }
        }
        
        return cnt % 2 == 0;
        
    }
}