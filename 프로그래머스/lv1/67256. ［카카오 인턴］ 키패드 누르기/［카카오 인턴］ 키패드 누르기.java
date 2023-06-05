/*
    1 2 3
    4 5 6
    7 8 9
    * 0 #
*/
import java.util.*;
class Solution {
    int[] leftHand = new int[]{3,0};
    int[] rightHand = new int[]{3,2};
    Map<Integer, int[]> map = new HashMap<>();
    public String solution(int[] numbers, String hand) {
        String answer = "";
        init();
        for(int num : numbers){
            
            int[] next = getPosition(num);
            answer += move(next,hand);
            
        }
        
        
        
        
        return answer;
    }
    
    public String move(int[] next, String hand){
        
        if(next[1] == 0 || next[1] ==0 || next[1] == 0) {
             leftHand[0] = next[0];
            leftHand[1] = next[1];
            return "L";
        }
        if(next[1] == 2 || next[1] == 2 || next[1] ==2){
              rightHand[0] = next[0];
             rightHand[1] = next[1];
            return "R";
        }
        
        int leftDis = Math.abs(next[0] - leftHand[0])+Math.abs(next[1] - leftHand[1]);
        int rightDis = Math.abs(next[0] - rightHand[0])+Math.abs(next[1] - rightHand[1]);

        if(leftDis < rightDis){
            leftHand[0] = next[0];
            leftHand[1] = next[1];
            return "L";
        }else if(rightDis < leftDis){
             rightHand[0] = next[0];
             rightHand[1] = next[1];
            return "R";
        }else{
            
            if(hand.equals("left")){
                  leftHand[0] = next[0];
                  leftHand[1] = next[1];
                  return "L";
            }else{
                rightHand[0] = next[0];
                rightHand[1] = next[1];
                 return "R";
            }
            
        }
        
    }
    
    public void init(){
        map.put(1,new int[]{0,0});
        map.put(2,new int[]{0,1});
        map.put(3,new int[]{0,2});
        
        map.put(4,new int[]{1,0});
        map.put(5,new int[]{1,1});
        map.put(6,new int[]{1,2});
        
        map.put(7,new int[]{2,0});
        map.put(8,new int[]{2,1});
        map.put(9,new int[]{2,2});
         
        map.put(0,new int[]{3,1});
        
    }
    
    public int[] getPosition(int n){
        return map.get(n);
    }
}