//https://school.programmers.co.kr/learn/courses/30/lessons/161989

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        
        int length = -1;
        
        for(int i=0; i<section.length; i++){
            
            int nextPainting = section[i] - 1;
            
            if(nextPainting == -1) continue;
            
            if(nextPainting > length){
                answer++;
                length = nextPainting+m-1;
            }
            
            section[i] = -1;
            
        }
        
        return answer;
    }
}