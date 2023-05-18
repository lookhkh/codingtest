/*
    매일 다른 옷을 조합.
    동일한 종류의 옷은 함께 입을 수 없으며, 동일 종류에선 최대 한 가지만 입을 수 있음.
    또한 어떤 종류의 옷 중 아무것도 입지 않을 수도 있음.
    의상의 일부가 겹쳐도, 추가로 다른 의상을 착용하거나 하는 등, 전체적으로 다르다면 인정
    하루에 최소 한 개의 의상은 입는다.

*/
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,List<String>> list = new HashMap<>();
        
        for(String[] cloth : clothes){
            List<String> arr = list.getOrDefault(cloth[1], new ArrayList<String>());
            arr.add(cloth[0]);
            list.put(cloth[1], arr);
        }
        
         int[] result = new ArrayList<>(list.entrySet()).stream()
                                         .mapToInt(t->t.getValue().size())
                                         .toArray();
        
         for(int n : result){
             answer *= (n+1);
         }
        
        
        
        return answer-1;
    }
}