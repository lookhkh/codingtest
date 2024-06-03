import java.util.*;
import java.util.stream.Collectors;
class Solution {
    Map<String, Integer> table = new HashMap<>();
    Map<String, List<Song>> list = new HashMap<>();
    
    public List<Integer> solution(String[] genres, int[] plays) {
    
        for(int i=0; i<plays.length; i++){
            Song next = new Song(i, genres[i], plays[i]);  
            table.put(next.genre, table.getOrDefault(next.genre,0)+plays[i]);
            List<Song> songs = list.getOrDefault(next.genre, new ArrayList<>());
            songs.add(next);
            list.put(next.genre, songs);
        }
        
        Iterator<String> keys = list.keySet().iterator();
        List<Song> ans = new ArrayList<>();
        while(keys.hasNext()){
            String key = keys.next();
            List<Song> songs = list.get(key);
            ans.addAll(songs.stream()
                .sorted((t1,t2)->{
                    if(t1.count != t2.count) return Integer.compare(t2.count, t1.count);
                    return Integer.compare(t1.id, t2.id);
                })
                .limit(2)
                .collect(Collectors.toList()));
        }
        
        return ans.stream()
            .sorted((t1,t2)->Integer.compare(table.get(t2.genre), table.get(t1.genre)))
            .map(t->t.id)
            .collect(Collectors.toList());

    }
}

class Song{
    int id;
    String genre;
    int count;
    Song(int id, String ge, int count){
        this.id = id;
        this.genre = ge;
        this.count = count;
    }
    
    @Override
    public String toString(){
        return id+" "+genre+" "+count;
    }
}