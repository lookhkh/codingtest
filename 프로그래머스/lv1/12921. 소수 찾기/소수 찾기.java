class Solution {
    boolean[] isPrimeNumber;
    public int solution(int n) {
        int answer = 0;
        isPrimeNumber = new boolean[n+1];
        
        isPrimeNumber[1] = true;
        
        for(int i=2; i<=n; i++){
            
            for(int j=i+i; j<=n; j+=i){
                isPrimeNumber[j] = true;
            }
            
        }
        
        for(int i=2; i<=n; i++){
            if(!isPrimeNumber[i]) answer++;
        }
        
        return answer;
    }
}