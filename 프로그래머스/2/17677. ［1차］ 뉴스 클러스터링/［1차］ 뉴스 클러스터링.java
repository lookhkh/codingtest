/**
    1. 자카드 유사도
        A,B에 대하여 J(A,B)는 두 집합의 교집합의 크기를, 두 집합의 합집합 크기로 나눈 값.
        A,B의 교집합이 공집합일 경우에는, 1로 정의
**/
import java.util.*;
class Solution {
    Set<String> keys = new HashSet<>();
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer> str1s = convert(convert(str1));
        Map<String,Integer> str2s = convert(convert(str2));
        
        List<String> key = new ArrayList<>(keys);
        
        if(key.size() == 0) return 65536;
        
        float common = 0;
        float sum = 0;
        
        for(String nextKey : key){
            int r1 = str1s.getOrDefault(nextKey, 0);
            int r2 = str2s.getOrDefault(nextKey, 0);
            
            common += Integer.min(r1,r2) * 1.0;
            sum += Integer.max(r1,r2)*1.0;
        }
        System.out.println(common+" "+sum);
        if(common == 0) return 0;
        if(sum == 0) return 65536;
        int re = (int)((common / sum) * 65536.0);
        
        
        return re;
    }
    
    Map<String,Integer> convert(List<String> list){
        
        Map<String,Integer> map = new HashMap<>();
        for(String next : list){
            map.put(next, map.getOrDefault(next,0)+1);
        }
        return map;
        
    }
    
    List<String> convert(String str){
        str = str.toLowerCase();
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.length()-1; i++){
            char first = str.charAt(i);
            char second = str.charAt(i+1);
            if(isAlpha(first) && isAlpha(second)){
                String r = first+""+second+"";  
                list.add(r);
                keys.add(r);
            } 
        }
        
        return list;
                
    }
    
    boolean isAlpha(char a){
        return a >='a'&& a <='z';
    }
    
    
}