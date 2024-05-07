class Solution {
    int answer = 0;
    public int solution(int n) {
        int answer = 0;
        int[] pos = new int[n];
        
        backtracking(0, pos);
        
        return this.answer;
    }
    
    void backtracking(int idx, int[] pos){
        
        if(idx == pos.length){
            this.answer++;
        }else{
            
            for(int i=0; i<pos.length; i++){
                if(idx !=0 && !isOkay(idx, i, pos)) continue;
                pos[idx] = i;
                backtracking(idx+1, pos);
            }
            
        }
    }
    
    boolean isOkay(int idx , int target, int[] pos){
  
        int x = idx;
        int y = target;   
        for(int i=0; i<idx; i++){
            int prevX = i;
            int prevY = pos[prevX];
            
            if(prevY == y) return false;
            if( (Math.abs(prevY - y) * 1.0 / Math.abs(prevX - x) * 1.0) == 1) return false;
            
        }

        return true;
    }
}