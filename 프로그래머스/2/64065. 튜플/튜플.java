/*
1. 튜플은 순서가 있으며, 원소의 개수는 유한하다.
2. 문제로 주어진 튜플은 원소의 개수가 n개이며, 중복되는 원소는 없다.
3. 이를 표현하면 (a1,a2,a3,....an)으로 표현가능
4. 이때, 이를 집합으로 표현가능하며, 집합 내에서는 튜플의 원소의 순서가 변경 가능하다.
5. 튜플의 최대 길이는 500.
*/
import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length());
        s = s.substring(0, s.length()-1);
        s = s.substring(0, s.length());
        s = s.substring(1, s.length()-1);
        
        String[] arr = s.split("\\},\\{");
        List<String[]> list = new ArrayList<>();
        for(String next : arr){
            String[] ar = next.split(",");
            list.add(ar);
        }
        
        list.sort((t1,t2)->Integer.compare(t1.length, t2.length));
        int[] answer = new int[list.get(list.size()-1).length];
        Set<Integer> set = new HashSet<>();
        int idx = 0;
        
        for(String[] next: list){
            for(String n : next){
                int t = Integer.parseInt(n);
                if(set.add(t)) answer[idx++] = t;
            }
        }
        
        
        return answer;
    }
}