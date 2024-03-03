class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n == 1) return 1;
        int left = 1;
        int right = 2;
        int temp = left;
        
        while(right <= n){
            temp+= right++;
            while(temp >= n){
                if(temp == n) answer++;
                temp-= left;
                left++;
            }
        }

        return answer;
    }
}