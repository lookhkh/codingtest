/*
    양의 정수 n (n > 0)
    => k 진수로 변경.
    변경된 수 안에 조건에 맞는 소수의 개수
    
    1. 0P0 소수 양쪽에 0이 있는 경우
    2. P0 처럼, 소수 오른쪽에만 0이 있고, 왼쪽에는 아무것도 없는 경우
    3. 0P 처럼, 소수 왼쪽에만 0이 있고, 오른쪽에는 아무것도 없는 경우
    4. P 처럼, 소수 양쪽에 아무것도 없는 경우
    5. P는 0을 포함하지 않는 소수. 123,5,7,13,19....

    

*/
class Solution {
    
    public int solution(int n, int k) {
        int answer = 0;
        
        String converted = getNth(n,k);
        
        String[] arr = converted.replaceAll("0"," ").split(" ");

        for(String w : arr){
            if(w.length() == 0) continue;
            if(isPrimeNumber(w)){
                System.out.println(w);
                answer++;
            }            
        }
        
        return answer;
    }
    
    
    public String getNth(int n, int k){
        if(n == 0) return "";
        if(n < k) return String.valueOf(n);
        return getNth(n/k,k)+Integer.valueOf(n % k);
    }
    
    public boolean isPrimeNumber(String num){
        long n = Long.valueOf(num);
        if( n == 1) return false;
        for(int i=2; i<=(int)Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}