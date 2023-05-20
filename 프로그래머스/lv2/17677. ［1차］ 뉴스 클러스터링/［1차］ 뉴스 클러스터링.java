/*

    자카드 유사도. 
    집합간의 유사도
    두 집합의 교집합 크기를 두 집합의 합집합으로 나누는 값.
    두 집합이 모두 공집합일 경우, 자카드 유사도는 1이다.
    
    입력으로 들어온 문자열을 두 글자씩 끊어서 다중집합의 원소로 만든다.
    다중집합 원소 비교 시, 대소문자 차이는 무시. 
    다중집합으로 만들 시, 영문자로만 구성된 쌍만 유효하며, 그렇지 않은 쌍은 버린다.

*/
import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String,Integer> s1 = getPartialList(str1);
        Map<String,Integer> s2 = getPartialList(str2);
                
        
        System.out.println(s1);
        System.out.println(s2);
    
        if(s1.size() == 0 && s2.size() == 0) return 65536;
        
        double result = 교집합(s1,s2) * 1.0;
        double result2 = 합집합(s1,s2) * 1.0;
    
        int r = (int)((result / result2) * 65536);

        return r;
    }
    
    public Map<String,Integer> getPartialList(String str){
        str= str.toLowerCase();
        
        Map<String,Integer> list = new HashMap<>();
        
        for(int i=0; i<str.length()-1; i++){
            String next = str.substring(i,i+2);
            boolean isValid = true;
            for(int z=0; z<2; z++){
                char n = next.charAt(z);
                if(!(n>='a' && n<='z')) isValid = false;
            }
            
            if(isValid){
                list.put(next, list.getOrDefault(next,0)+1);
            } 
        }
        
        return list;
    }
    
    public int 교집합(Map<String,Integer> original, Map<String,Integer> target){
          List<String> key1 = new ArrayList<>(original.keySet());
          List<String> key2 = new ArrayList<>(target.keySet());
            
          int cnt = 0;
        
          for(int i=0; i<key1.size(); i++){
            
            String n = key1.get(i);
            if(target.containsKey(n)) cnt+=Math.min(target.get(n), original.get(n));      
        }
        
        return cnt;
        
    }
    
    public int 합집합(Map<String,Integer> original, Map<String,Integer> target){
        
        List<String> key1 = new ArrayList<>(original.keySet());
        List<String> key2 = new ArrayList<>(target.keySet());
            
        int cnt = 0;
        
        for(int i=0; i<key1.size(); i++){
            
            String n = key1.get(i);
            if(target.containsKey(n)) cnt+=Math.max(target.get(n), original.get(n)); 
            else cnt+=original.get(n);
        }
        
         for(int i=0; i<key2.size(); i++){
            
            String n = key2.get(i);
            if(!original.containsKey(n)) cnt+=target.get(n);
        }
        
        return cnt;
        
    }
}