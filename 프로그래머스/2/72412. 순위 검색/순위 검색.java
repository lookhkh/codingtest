import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Store store= new Store();
        
        for(String next : info){
            store.insert(next);
        }
        
        
        int idx = 0;
        for(String next : query){
            int val = store.find(next);
            answer[idx++] = val;
        }
        
        return answer;
    }
}



class Store{
    Map<String, List<Integer>> store = new HashMap<>();
    static String[] lans = new String[]{"java","python","cpp","-"};
    static String[] poss = new String[]{"backend","frontend","-"};
    static String[] exps = new String[]{"junior","senior","-"};
    static String[] foods = new String[]{"pizza","chicken","-"};
    
    public Store(){
        
        for(String lan : lans){
            for(String pos : poss){
                for(String exp : exps){
                    for(String food : foods){
                        String key = createKey(lan, pos, exp, food);
                        store.put(key, new ArrayList<Integer>());
                    }
                }
            }
        }
        

    }
    
    String createKey(String lan, String pos, String exp, String food){
        return lan + pos + exp + food;
    }
    
    void insert(String query){
        String[] arr = query.split(" ");
        int val = Integer.parseInt(arr[4]);
        String key = createKey(arr[0], arr[1], arr[2], arr[3]);
        this.store.get(key).add(val);
        this.store.get(key).sort(null);
    }
    
    int find(String query){
        String[] arr = query.split(" ");
        String lan = arr[0];
        String pos = arr[2];
        String exp = arr[4];
        String food = arr[6];
        int score = Integer.parseInt(arr[7]);
        
        List<String> lanList = createLan(lan, lans);
        List<String> posList = createLan(pos, poss);
        List<String> expList = createLan(exp, exps);
        List<String> foodList = createLan(food, foods);
        
        int sum = 0;

        for(String a : lanList){
            for(String b : posList){
                for(String c : expList){
                    for(String d : foodList){
                        String finalKey =  createKey(a, b,c,d);
                        List<Integer> scores = this.store.get(finalKey);
                        if(scores.isEmpty()) continue;
                        sum += binarySearch(score, scores);
                        
                     }
                }
            }
        }

        
        return sum;
    }
    
    int binarySearch(int score, List<Integer> scores){
        
        int l = 0;
        int r = scores.size();
        
        while(l < r){
            
            int mid = (l+r) / 2;
            int value = scores.get(mid); 
            
            if(value >= score){
                r = mid;
            }else{
                l = mid+1;
            }
            
        }
        
        
        return scores.size() - l;
    }
    
    List<String> createLan(String query, String[] arr){
        if(!query.equals("-")) return Arrays.asList(query);
        List<String> ans = new ArrayList<>();
        for(String next : arr){
            if(next.equals(query)) continue;
            ans.add(next);
        }
        
        return ans;
        
    }

}