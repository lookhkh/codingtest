//https://school.programmers.co.kr/learn/courses/30/lessons/140107


class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i*k<=d; i++){
            
            int nextX= i*k;
        
            
            /*
                R^2 = X^2+Y^2;
                Y^2 = R^2 - X^2;
            */
            
            int nextY = (int)Math.floor(Math.sqrt(Math.pow(d,2) - Math.pow(nextX,2)));
            
                answer+=nextY/k+1;
            

        }
        
        return answer;
    }
}