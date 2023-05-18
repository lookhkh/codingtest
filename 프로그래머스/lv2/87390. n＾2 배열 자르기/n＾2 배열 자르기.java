/*
    n * n 2차원 배열
    

*/
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right -left)+1] ;
        
        int leftRow = (int) (left / n);
        int leftCol = (int)(left % n);
        int rightRow = (int)(right / n);
        int rightCol = (int)(right % n);
        System.out.printf("%d row의 %d부터 %d row의 %d까지",leftRow,leftCol,rightRow,rightCol);
        
        int idx = 0;
        for(int i=leftRow; i<=rightRow; i++){
            
            for(int j=0; j<n; j++){
                
                if(i == leftRow && j < leftCol) continue;
                if(i == rightRow && j > rightCol) continue;
                
                 if(j < i) answer[idx++] = i+1;
                 else answer[idx++] = j+1; 
                
                
            }
            
        }
        
        return answer;
    }
}