/*
    롤케이크를 두 조각으로 잘라서 나눠 먹는다.
    토핑이 일려로 올려져 있다.
    토핑을 공평하게 나눠먹는다.
    
    공평하게 => 동일한 가짓수의 토핑을 가져간다. ( 케익 크기나, 토핑 수 상관X)
    배열의 두 개의 점을 고른다. 이때 두 점을 x,y라 하면
    0~x, y~x까지 나눈다.
*/
import java.util.*;
class Solution {
    
    int wholeKinds = 0;
    
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<topping.length; i++){
            int n = topping[i];
            map.put(n, map.getOrDefault(n,0)+1);
        }
        wholeKinds = map.keySet().size();

        for(int i=0; i<topping.length; i++){
            
            int next = topping[i];
            
            map.put(next, map.get(next)-1);
            
            set.add(next);
            
            if(map.get(next) <= 0) map.remove(next);
          
            if(map.keySet().size() == set.size()) answer++;

        }
            
        return answer;
    }
}