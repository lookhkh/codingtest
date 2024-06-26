/**
1. 도시 이름을 검색하면, 데이터베이스에서 데이터를 읽어와 보여주는 기능
2. DB 캐시를 이용
3. but, 캐시 크기를 얼마나?


**/
import java.util.*;
class Solution {
   
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        CacheLRU cache = new CacheLRU(cacheSize);
        for (String city : cities) {
            if(cache.contains(city)) {
                cache.get(city);
                answer += 1;
            }
            else {
                cache.put(city);
                answer+=5;
            }
        }

        return answer;
    }
}

class CacheLRU{

    int size;
    Map<String,Boolean> cache;

    public CacheLRU(int size){
        this.size = size;
        this.cache = new  LinkedHashMap<>();
    }

    boolean contains(String key){
        key = key.toUpperCase();
        return this.cache.containsKey(key);
    }

    void get(String key){
        key = key.toUpperCase();
        this.cache.remove(key);
        this.cache.put(key, true);
    }

    void put(String key){
        key = key.toUpperCase();
        if(this.cache.size() < this.size) {
            this.cache.remove(key);
            this.cache.put(key, true);
        }else{

         LinkedHashMap<String, Boolean> tree = (LinkedHashMap<String, Boolean>) this.cache;
            Map.Entry<String, Boolean> first = tree.entrySet().stream().findFirst().orElseGet(()->null);
            if(first == null) return;
            String removedKey = first.getKey();
            tree.remove(removedKey);
            this.put(key);

        }
    }

}

