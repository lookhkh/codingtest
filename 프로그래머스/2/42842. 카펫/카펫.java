/**
1. 테두리는 갈색으로 칠한다.
2. 그 외에는 노란색으로 칠한다.
3. 가로는 세로보다 항상 같거나 크다.

**/
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = yellow;
        int y = 0;
        
        while(x >= y){
            y++;
            if(yellow % y !=0) continue;
            x = yellow / y;
            
            if(2 * (x+2) + 2*y == brown) break;
            
            
        }
        
        System.out.println(x+" "+y);
        answer[0] = x+2;
        answer[1] = y+2;
        return answer;
    }
}