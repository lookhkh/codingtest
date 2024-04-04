class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int min = Integer.MAX_VALUE;
        int left = 0;
        long sum = sequence[left];
        if(sum == k) return new int[]{0,0};
        
        for(int i=1; i<sequence.length; i++){
            
            int next = sequence[i];
            sum+= next;
            while(left <= i && sum >= k){
                if(sum == k && i - left < min){
                    min = i - left;
                    answer[0] = left;
                    answer[1] = i;
                }
                
                sum -= sequence[left++];
            }
            
            
        }
        
        
        
        return answer;
    }
}