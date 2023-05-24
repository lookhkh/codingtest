/*
    1. 부분수열.
    2. 부분 수열의 합은 k
    3. 동일한 부분 수열이 복수개 있을 경우, 길이가 짧은 놈
    3번을 만족하는 놈이 복수개 있을 경우, 제일 앞에 있는 놈.

*/
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        
        int sum = 0;
        
        int left = 0;
        for(int i=0; i<sequence.length; i++){
            
            int next = sequence[i];
            sum+= next;
            if(sum >= k){
                while(sum >= k){
                    
                    if(sum == k) {
                        if(minLength > i-left+1){
                            minLength = i-left+1;
                            answer[0] = left;
                            answer[1] = i;
                        }
                    }
                    
                    sum -= sequence[left++];
                    
                }
            }
            
        }
        
        return answer;
    }
}