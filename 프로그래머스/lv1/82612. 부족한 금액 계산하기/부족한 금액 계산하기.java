class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long tempSum = 0;
        for(int i=1; i<=count; i++){
            tempSum+=price * i;
        }
        
        if(money >= tempSum) return 0;
        
        return tempSum-money;
    }
}