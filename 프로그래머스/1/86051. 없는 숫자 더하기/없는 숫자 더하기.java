import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Set<Integer> nums = new HashSet<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        
        for(int num : numbers){
            nums.remove(num);
        }
        
        for(int num : new ArrayList<>(nums)){
            answer+=num;
        }
        
        return answer;
    }
}