/*
    한자리 숫자가 적힌 종이 조각.
    종이조각을 조합하여 몇 개의 소수를 만들 수 있는가?
    1~7이하인 문자열,
    
    7 * 7 * 7 * 7 * 7 * 7 * 7

*/
import java.util.*;
import java.lang.StringBuilder;

class Solution {
    String[] nums;
    Set<Integer> set;
    int answer= 0 ;
    public int solution(String numbers) {
        nums = numbers.split("");
        set = new HashSet<>();
        
        int size = numbers.length();
        
        dfs(0,new String[size], new boolean[size]);
        
        return answer;
    }
    
    public void dfs(int cnt, String[] r, boolean[] ch){
        
        if(cnt == r.length){

            StringBuilder t= new StringBuilder();
            
            for(int i=0 ;i<r.length; i++){
                if(r[i]!= null ) t.append(r[i]);
            }
            
            if(t.length()<=0) return;
            int ne = Integer.valueOf(t.toString().trim());
            
            if(set.contains(ne)) return;
            
            set.add(ne);

            if(isPrimeNumber(ne)) answer++;
            
        }else{
            
            dfs(cnt+1,r,ch);
            
            for(int i=0; i<nums.length; i++){
               
                if(ch[i]) continue;
                
                ch[i] = true;
                
                r[cnt] = nums[i];
                
                dfs(cnt+1,r,ch);
               
                ch[i] = false;
                
                r[cnt] = null;
            }
            
        }
        
    }
    
    public boolean isPrimeNumber(int num){
        int t = num;
        if(t <= 1) return false;
        
        for(int i=2; i<=(int)Math.sqrt(t); i++){
            if(t % i == 0) return false;
        }
        
        return true;
        
        
    }
}