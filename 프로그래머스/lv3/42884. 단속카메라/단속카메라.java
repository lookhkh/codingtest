import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        for(int[] route : routes){
            Arrays.sort(route);
        }
        
        Arrays.sort(routes, (t1,t2)->Integer.compare(t1[1],t2[1]));           
        int defaultVal = -30_001;
        int prev = defaultVal;
        
        for(int i=0; i<routes.length; i++){
            
            int[] route = routes[i];
            
            if(prev == defaultVal){
                answer++;
                prev = route[1];
            }else{
                
                if(route[0] <= prev && route[1] >= prev){
                    
                }else{
                    answer++;
                    prev = route[1];
                }
                
            }
            
            
        }
        
        
        return answer;
    }
}