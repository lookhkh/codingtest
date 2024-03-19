import java.util.*;
class Solution {
    Map<String,Integer> table = new HashMap<>();
    Map<Integer, Set<String>> map = new HashMap<>();
    Map<Integer, Integer> maxTable = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
            
        for(int next : course){
            for(String order : orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                char[] path = new char[next];
                dfs(0,0, next, arr, path);
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        for(int num :  course){
            
            if(!map.containsKey(num)) continue;
            int max = maxTable.get(num);
            Set<String> arg = map.get(num);
            Iterator<String> itr = arg.iterator();
            while(itr.hasNext()){
                String nextOne = itr.next();
                if(table.getOrDefault(nextOne,0) != max) itr.remove();
            }
            ans.addAll(arg);
        }
        Collections.sort(ans);
        
        return ans.toArray(String[]::new);
    }
    
    void dfs(int cur, int idx, int len,char[] order, char[] path){
        if(cur == len){
            String str = create(path);
            table.put(str, table.getOrDefault(str,0)+1);
            int curCnt = table.get(str);
            
            if(curCnt>=2){
                Set<String> ar = map.getOrDefault(len, new HashSet<>());
                ar.add(str);
                map.put(len, ar);
                maxTable.put(len, Integer.max(curCnt, maxTable.getOrDefault(len,0)));
            }
        }else{
            for(int i=idx; i<order.length; i++){
                
                path[cur] = order[i];
                dfs(cur+1, i+1,len,order, path);
            }
            
        }
    }
    
    String create(char[] arr){
        StringBuilder b = new StringBuilder();
        for(char n : arr) b.append(n);
        return b.toString();
    }
}