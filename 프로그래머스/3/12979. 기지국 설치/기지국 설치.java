class Solution {
    public int solution(int n, int[] st, int w) {
        int answer = 0;
        
        int lastIdx = -1;
        int length = w * 2 +1;
        for(int i=0; i<st.length; i++){
            
            int idx = st[i] - 1;
            if(i == 0){
                
                int left = idx - w;
                answer+=calc(left, length);
                
            }else{
                
                int right = lastIdx+w+1;
                int left = idx - w - 1;

                int len = (left - right)+1;
                answer+= calc(len, length);
            }
            
            lastIdx = idx;
            
        }
        
        if(lastIdx+w < n){
            answer+=calc(n-(lastIdx+w)-1, length);
        }
        
        
        return answer;
    }
    
    int calc(int num, int w){
    
        if(num <= 0) return 0;
        if (num % w == 0) {
            return (num / w);
        } else {
            return (num /w) + 1;
        }
    }
}