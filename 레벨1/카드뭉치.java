//https://school.programmers.co.kr/learn/courses/30/lessons/159994

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        String answer = "";
        
        
        int leftIdx = 0;
        int rightIdx = 0;
        
        int goalIdx = 0;
        
        while(goalIdx<goal.length){
            
            String nextGoal = goal[goalIdx];
            
            if(leftIdx <cards1.length && cards1[leftIdx].equals(nextGoal)){
                leftIdx++;
                goalIdx++;
            }else if(rightIdx < cards2.length && cards2[rightIdx].equals(nextGoal)){
                goalIdx++;
                rightIdx++;
            }else{
                return "No";
            }
            
        }
        
        return "Yes";
    }
}