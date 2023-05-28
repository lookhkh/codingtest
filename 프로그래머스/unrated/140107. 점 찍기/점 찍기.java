/*
    x^2 >= a^2+b^2
    x^2 - a^2 >= b^2;
*/
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i*k<=d; i++){
            int ik = i*k;
            int max = (int)Math.floor(Math.sqrt((Math.pow(d,2) - Math.pow(ik,2))));
            answer += (max / k+1);
        }
        
        return answer;
    }
    
    public boolean isWithinDis(int x, int y, int d){
        return d>=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
}