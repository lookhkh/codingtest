/**
1. timelogs에서, 토,일은 제외해야 한다.
2. 

**/
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++){
            int hopedTime = schedules[i];
            int hour = hopedTime / 100;
            int minute = hopedTime % 100;

            int plusMin = minute + 10;
            if(plusMin >= 60){
                plusMin = plusMin % 60;
                hour+=1;
            }
            schedules[i] = hour* 100 + plusMin;
        }
        
        startday -= 1;

        for(int i=0; i<schedules.length; i++){
            int day = startday;
            int expectedTime = schedules[i];
            int[] timelog = timelogs[i];
            boolean isOkay = true;
            for(int j=0; j<timelog.length; j++){
                int curTime = timelog[j];
                if(expectedTime < curTime && (day != 5 && day != 6)){
                    isOkay = false;
                    break;
                }
                
                day++;
                day %= 7;
            }
            
            if(isOkay) answer++;
            
        }
                
        return answer;
    }
}