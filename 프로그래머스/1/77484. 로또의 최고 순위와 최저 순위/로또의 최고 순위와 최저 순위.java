import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        Map<Integer, Integer> table = 
            Map.of(6,1, 5,2, 4,3, 3,4, 2,5, 1,6,0,6);
        int zeroNum = 0;
        Map<Integer, Integer> myLottos = new HashMap<>();
        for(int num : lottos){
            myLottos.put(num, 1);
            if(num == 0) zeroNum++;
        }
        
        int answerNum = 0;
        for(int win : win_nums){
            if(myLottos.containsKey(win)) answerNum++;
        }
        
        answer[0] = table.get(answerNum + zeroNum);
        answer[1] = table.get(answerNum);

        return answer;
    }
}