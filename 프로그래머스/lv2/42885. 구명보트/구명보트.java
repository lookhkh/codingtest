/*
    배열과 구명보트의 최대 무게가 주어진다.
    구명보트는 최대 무게 내애서 한 번에 최대 두 명의 사람을 태울 수 있다.
    가장 적게 구명보트를 사용하는 경우를 구하라
    구명보트의 무게는 가장 무거운 사람보다 항상 크기 때문에 실패하는 경우는 없다.

*/
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left =0;
        int right = people.length-1;
        
        int cnt = 0;
        while(left <= right){
            
            if(people[left]+people[right] <= limit){
                left++;
                right--;
                cnt++;
            }else{
                right--;
                cnt++;
            }
            
        }
        
        return cnt;
    }
}