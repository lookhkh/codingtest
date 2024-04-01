import java.util.*;
class Solution {
          public int solution(int[] ingredient) {
            int answer = 0;
            int[] lists = new int[ingredient.length+1];
            int lastIdx = 0;
            for (int next : ingredient) {
                lists[lastIdx] = next;
                if(lastIdx >= 3 && lists[lastIdx]==1 && lists[lastIdx-1]==3 && lists[lastIdx-2]==2 && lists[lastIdx-3]==1){
                    lastIdx-=3;
                    answer++;
                }else{
                    lastIdx++;
                }
            }


            return answer;
        }

}