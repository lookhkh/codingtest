/*
    도시 이름을 key로 하여, 필요한 데이터를 쿼리한다.
    캐시를 사용하여 성능을 높이고자 한다.
    이때, 캐시의 크기를 설정해야 한다.
    
    캐시 크기에 따른 실행시간 측정 프로그램을 작성한다.
    key는 영문자로만 이루어져 있으며, 대소문자를 구분하지 않는다.
    cache hit => 1초
    cache miss => 5초
    
    LRU => 가장 마지막으로 사용된 캐시를 삭제한다.
*/
import java.util.*;
import java.util.Map.Entry;

class Solution {
    
    Map<String,Integer> cache;
    
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        cache = new HashMap<>();
        
        if(cacheSize == 0) return cities.length * 5;

        for(int i=0; i<cities.length; i++){
            
            String next = cities[i].toLowerCase();
            
            if(cache.containsKey(next)){
                cacheUpdate(next,i);
                answer+=1;
            }else{
                
                if(cache.size() >= cacheSize) cacheEvict();
                
                cacheUpdate(next,i);
                
                answer+=5;
            }
            
                
            
        }
        
        return answer;
    }
    
    public int cacheUpdate(String key, int idx){
        cache.put(key,idx);
        return 1;
    }
    
    public void cacheEvict(){
        
       Entry<String, Integer> lastUsed = new ArrayList<>(cache.entrySet())
                                                .stream()
                                                .sorted((t1,t2)->Integer.compare(t1.getValue(),t2.getValue()))
                                                .findFirst()
                                                .get();
        
       cache.remove(lastUsed.getKey());
        
    }

}