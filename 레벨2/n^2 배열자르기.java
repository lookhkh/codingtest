//https://school.programmers.co.kr/learn/courses/30/lessons/87390

class Solution {
    public int[] solution(int n, long left, long right) {
         int[] answer = new int[(int)(right - left)+1];
         int cnt = 0;
         long[] start = getIdx(left,n);
         long[] end = getIdx(right,n);
        
        
        
          for(long i=start[0]; i<=end[0]; i++){
              for(long j=0; j<n; j++){
                  if(i == start[0] && j<start[1]) continue;  
                  if(i == end[0] && j>end[1]) continue;
                  
                  long startNumber = i+1;
                  long valueAtTheIdx = getValueFromIdx(startNumber, j, n);
                  answer[cnt++] = (int)valueAtTheIdx;
              }
              
          }
        
        
        return answer;
    }
    public long[] getIdx(long num, long n){
        long[] result = new long[2];
        result[0] = num/n;
        result[1] = num % n;
        return result;
    }
    
    public long getValueFromIdx(long startNumber, long idx, int n){
        
        if(startNumber <= idx+1){
            return idx+1;
        }
        
        return startNumber;
        
        
    }
}