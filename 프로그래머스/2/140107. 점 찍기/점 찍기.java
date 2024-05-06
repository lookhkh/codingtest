class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0; i * k <=d; i++){
           double b = distance(0,0, i*k,0);
           double maxY = Math.floor((Math.sqrt(Math.pow(d,2) - Math.pow(b,2))) / k);
           answer+=maxY+1;
        }
        
        return answer;
    }
    
    double distance(int x, int y, int x1, int y1){
        return Math.sqrt(Math.pow(x1-x, 2) + Math.pow(y1-y,2));
    }
}