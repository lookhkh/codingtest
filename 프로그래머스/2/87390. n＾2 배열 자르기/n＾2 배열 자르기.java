class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left)+1;
        int[] answer = new int[size];
        
        int x = (int)(left / n);
        int y = (int)(left % n);
        int idx = 0;
        
        
        while(idx < size){
            if(y <= x) answer[idx++] = x+1;
            if(y > x) answer[idx++] = y+1;
            
            y++;
            if( y == n){
                y = 0;
                x++;
            }
            
        }
        return answer;
    }
}