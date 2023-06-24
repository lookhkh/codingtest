import java.util.*;
class Solution {
    int[] x = new int[10];
    int[] y = new int[10];
    public String solution(String X, String Y) {
        
        for(int i=0; i<X.length(); i++){
            x[X.charAt(i)-'0']++;
        }
        
        for(int i=0; i<Y.length(); i++){
            y[Y.charAt(i)-'0']++;
        }
        
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<x.length; i++){
            int nextX = x[i];
            int nextY = y[i];
            
            if(nextX !=0 && nextY !=0){
                
                for(int j=0; j<Math.min(nextX,nextY); j++){
                    list.add(i);
                }
                
            }
        }
        list.sort(null);
        
        StringBuilder n = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            n.append(list.get(i));
        }
        
        String answer = n.toString();
        
        if(answer.equals("")) return "-1";
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}